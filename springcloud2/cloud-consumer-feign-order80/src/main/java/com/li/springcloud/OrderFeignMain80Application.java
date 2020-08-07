package com.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //切记当出现新功能时要开启对他的支持
public class OrderFeignMain80Application {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80Application.class,args);
    }
}


