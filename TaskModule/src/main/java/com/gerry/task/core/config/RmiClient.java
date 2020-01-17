package com.gerry.task.core.config;

import com.jnshu.common.service.SmsCodeSendService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class RmiClient {

    @Bean(name = "smsCodeSendService")
    public RmiProxyFactoryBean getUserService() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:2002/smsCodeSendService");
        rmiProxyFactoryBean.setServiceInterface(SmsCodeSendService.class);
        return rmiProxyFactoryBean;
    }
}