package com.jnshu.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.jnshu")
public class NotifyApplication {
//        extends SpringBootServletInitializer implements WebApplicationInitializer {
    static Logger logger = LoggerFactory.getLogger(NotifyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NotifyApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(Application.class);
//    }
}
