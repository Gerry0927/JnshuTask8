package com.jnshu.notify.config;

import com.jnshu.common.service.SmsCodeSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import javax.annotation.Resource;

@Configuration
public class RmiServer {

    @Resource
    private SmsCodeSendService smsCodeSendService;

    @Bean
    public RmiServiceExporter getRmiServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("smsCodeSendService");
        rmiServiceExporter.setService(smsCodeSendService);
        rmiServiceExporter.setServiceInterface(SmsCodeSendService.class);
        rmiServiceExporter.setRegistryPort(2002);
        return rmiServiceExporter;
    }
}