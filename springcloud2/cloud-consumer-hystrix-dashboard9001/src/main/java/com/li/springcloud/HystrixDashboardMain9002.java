package com.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard  //开启HystrixDashboard的支持可视化页面
public class HystrixDashboardMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9002.class,args);
    }

}


