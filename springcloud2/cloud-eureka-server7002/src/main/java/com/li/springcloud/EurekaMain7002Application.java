package com.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 标注该服务是服务器从注册中心
public class EurekaMain7002Application {

      public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002Application.class,args);
      }

}
