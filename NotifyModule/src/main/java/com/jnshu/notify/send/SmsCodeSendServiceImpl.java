package com.jnshu.notify.send;

import com.jnshu.common.pojo.SmsInfo;
import com.jnshu.common.service.SmsCodeSendService;
import com.jnshu.common.utils.UUID;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsCodeSendServiceImpl implements SmsCodeSendService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @Autowired
//    private BatchingRabbitTemplate batchingRabbitTemplate;

    public SmsInfo sendSMSLoginCode(String phoneNum){

        SmsInfo smsInfo = new SmsInfo();
        smsInfo.setId(UUID.fastUUID().toString());
        smsInfo.setContent(RandomStringUtils.randomNumeric(4));
        smsInfo.setOutId(UUID.fastUUID().toString());
        smsInfo.setPhoneNum(phoneNum);

        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(smsInfo.getId());
        rabbitTemplate.convertAndSend("sms-exchange",
                "sms.login.code", //消息路由键
                 smsInfo,             //发送内容
                 correlationData);                      //消息唯一 id

        return smsInfo;
    }
}
