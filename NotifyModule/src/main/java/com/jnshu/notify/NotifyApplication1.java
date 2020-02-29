package com.jnshu.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ComponentScan(basePackages = "com.jnshu")
@ImportResource("classpath:dubbo.xml")
public class NotifyApplication1 {
        //extends SpringBootServletInitializer implements WebApplicationInitializer {
    static Logger logger = LoggerFactory.getLogger(NotifyApplication1.class);

    public static void main(String[] args) {
        SpringApplication.run(NotifyApplication1.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(NotifyApplication.class);
//    }
}
