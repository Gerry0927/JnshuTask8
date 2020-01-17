package com.gerry.task.service;


import com.gerry.task.pojo.UserInfo;

public interface UserInfoService {

    UserInfo findUserInfoByAccount(String phoneNum);

    UserInfo findUserInfoById(Integer userId);
}
