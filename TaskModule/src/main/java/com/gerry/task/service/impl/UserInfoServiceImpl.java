package com.gerry.task.service.impl;

import com.gerry.task.dao.UserInfoMapper;
import com.gerry.task.pojo.UserInfo;
import com.gerry.task.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findUserInfoByAccount(String phoneNum) {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhoneNum(phoneNum);
        return userInfoMapper.selectOne(userInfo);
    }

    @Override
    public UserInfo findUserInfoById(Integer userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }
}
