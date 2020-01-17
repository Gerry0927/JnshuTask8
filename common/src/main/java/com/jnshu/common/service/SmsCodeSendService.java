package com.jnshu.common.service;

import com.jnshu.common.pojo.SmsInfo;

public interface SmsCodeSendService {
    SmsInfo sendSMSLoginCode(String phoneNum);
}
