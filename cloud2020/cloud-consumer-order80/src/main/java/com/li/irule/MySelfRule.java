package com.li.irule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//改规则不能被componentScan注解所扫描到
@Configuration
public class MySelfRule {

    @Bean
    public IRule getRule(){
        //随机规则
        return new RandomRule();
    }
}
