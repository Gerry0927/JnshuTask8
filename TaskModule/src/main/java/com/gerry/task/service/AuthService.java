package com.gerry.task.service;


import com.jnshu.common.pojo.EmailInfo;
import com.jnshu.common.pojo.SmsInfo;
import com.gerry.task.pojo.UserInfo;

public interface AuthService {

    UserInfo login(UserInfo userInfo);
    Integer register(UserInfo userInfo);

    SmsInfo sendSMSCode(String phone);


}
