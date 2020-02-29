package com.gerry.task.service.impl;

import com.gerry.task.core.constant.ServiceExceptionEnum;
import com.gerry.task.core.exception.ServiceException;
import com.gerry.task.core.security.JwtUser;
import com.gerry.task.core.security.TokenService;
import com.gerry.task.dao.UserInfoMapper;
import com.gerry.task.service.AuthService;
import com.jnshu.common.pojo.EmailInfo;
import com.jnshu.common.pojo.SmsInfo;
import com.gerry.task.pojo.UserInfo;
import com.jnshu.common.redis.RedisCache;
import com.jnshu.common.service.SmsCodeSendService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Resource
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @Resource
    private SmsCodeSendService smsCodeSendService;

    @Override
    public SmsInfo sendSMSCode(String phone) {
        return smsCodeSendService.sendSMSLoginCode(phone);
    }


    @Override
    public UserInfo login(UserInfo userInfo) {
        String userName = userInfo.getPhoneNum();
        String password = userInfo.getPassword();

//        String smsCode = userInfo.getSmsCode();
//        String key = userName+"_"+smsCode;
//        String redisCode = redisCache.getCacheObject(SMS_KEY_PATTERN+key);
//        if(StringUtils.isEmpty(redisCode)|| redisCode.equals(smsCode)){
//            throw new ServiceException(ServiceExceptionEnum.USER_SMSCODE_ERROR);
//        }

        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(userName, password);
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(upToken);
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new ServiceException(ServiceExceptionEnum.USER_NOT_MATCH);
            } else {
                throw new ServiceException(ServiceExceptionEnum.USER_ACCOUNT_ERROR);
            }
        }
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        userInfo.setToken(tokenService.createToken(jwtUser));
        return userInfo;
    }

    @Override
    public Integer register(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        //判断用户是否存在（手机号码是唯一标识）
        example.createCriteria().andEqualTo("phoneNum", userInfo.getPhoneNum());
        int count = userInfoMapper.selectCountByExample(example);
        if (count > 0) {
            throw new ServiceException(ServiceExceptionEnum.USER_EXIST);
        }
        int rowId = userInfoMapper.insertSelective(userInfo);
        return userInfo.getUserId();
    }



}
