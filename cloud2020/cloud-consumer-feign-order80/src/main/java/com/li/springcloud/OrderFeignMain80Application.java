package com.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80Application {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80Application.class,args);
    }
}
