package com.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 标注该服务是服务中心
public class EurekaMain7001Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001Application.class,args);
    }
}
