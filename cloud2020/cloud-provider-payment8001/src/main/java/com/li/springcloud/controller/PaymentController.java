package com.li.springcloud.controller;

import com.li.springcloud.entities.CommonResult;
import com.li.springcloud.entities.Payment;
import com.li.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/addPaymentInfo")
    public CommonResult addPaymentInfo(@RequestBody Payment payment){
        System.out.println("payment = " + payment);
        int result = paymentService.addPaymentInfo(payment);
        log.info("================插入的结果为===================" + result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功 , serverPort: " + serverPort,result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
        }
    }

    @GetMapping("payment/queryPaymentById/{id}")
    public CommonResult queryPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.queryPaymentById(id);
        log.info("================查询的结果为===================" + payment);
        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort: " + serverPort,payment);
        }else{
            return new CommonResult(444,"查询失败" + id,null);
        }
    }
    @GetMapping("payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("=======================service:" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("=======================instance:" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serverPort;
    }



}
