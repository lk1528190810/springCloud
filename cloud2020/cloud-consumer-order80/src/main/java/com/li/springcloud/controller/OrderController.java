package com.li.springcloud.controller;

import com.li.springcloud.entities.CommonResult;
import com.li.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    //将端口写上注册在Eureka Server中的名称在配置类中的restTemplate加上@LoadBalanced的注解即可实现负载均衡
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/addPaymentInfo")
    public CommonResult<Payment> addPaymentInfo(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/addPaymentInfo",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/addPaymentInfoForEntity")
    public CommonResult<Payment> addPaymentInfo2(Payment payment){
       return restTemplate.postForEntity(PAYMENT_URL + "/payment/addPaymentInfo",payment,CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/queryPaymentById/{id}")
    public CommonResult<Payment> queryPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/queryPaymentById/" + id,CommonResult.class);
    }


    @GetMapping("/consumer/payment/queryPaymentByIdForEntity/{id}")
    public CommonResult<Payment> queryPaymentById2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/queryPaymentById/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }

}
