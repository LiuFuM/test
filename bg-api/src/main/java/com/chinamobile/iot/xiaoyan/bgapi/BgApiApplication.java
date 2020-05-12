package com.chinamobile.iot.xiaoyan.bgapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@SpringBootApplication
public class BgApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgApiApplication.class, args);
    }

}

