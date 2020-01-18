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

    @Resource
    private SmsCodeSendService smsCodeSendService2;

    @Bean
    public RmiServiceExporter getRmiServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("smsCodeSendService");
        rmiServiceExporter.setService(smsCodeSendService);
        rmiServiceExporter.setServiceInterface(SmsCodeSendService.class);
        rmiServiceExporter.setRegistryPort(2002);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter getRmiServiceExporter2() {
        RmiServiceExporter rmiServiceExporter2 = new RmiServiceExporter();
        rmiServiceExporter2.setServiceName("smsCodeSendService2");
        rmiServiceExporter2.setService(smsCodeSendService2);
        rmiServiceExporter2.setServiceInterface(SmsCodeSendService.class);
        rmiServiceExporter2.setRegistryPort(2003);
        return rmiServiceExporter2;
    }
}