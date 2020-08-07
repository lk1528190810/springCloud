package com.li.springcloud.dao;

import com.li.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentDao {
    //插入一条数据
    public int addPaymentInfo(Payment payment);

    //查询一条数据
    public Payment queryPaymentById(@Param("id") Long id);
}
