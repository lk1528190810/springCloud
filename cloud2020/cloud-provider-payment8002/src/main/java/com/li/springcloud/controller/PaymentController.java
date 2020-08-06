package com.li.springcloud.controller;

import com.li.springcloud.entities.CommonResult;
import com.li.springcloud.entities.Payment;
import com.li.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

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
}
