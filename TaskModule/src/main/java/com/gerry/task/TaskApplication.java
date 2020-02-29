package com.gerry.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.gerry.task.dao")
@ImportResource("classpath:dubbo.xml")
//@ComponentScan(basePackages = {"com.gerry","com.jnshu"})
public class TaskApplication {
        //extends SpringBootServletInitializer implements WebApplicationInitializer {
    static Logger logger = LoggerFactory.getLogger(TaskApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(TaskApplication.class);
//    }
}
