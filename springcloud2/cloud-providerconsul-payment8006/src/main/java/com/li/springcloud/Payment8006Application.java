package com.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient  //一定要加这个就是开启consul的支持
public class Payment8006Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8006Application.class,args);
    }
}


