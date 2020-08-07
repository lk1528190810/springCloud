package com.li.springcloud.service.impl;

import com.li.springcloud.dao.PaymentDao;
import com.li.springcloud.entities.Payment;
import com.li.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int addPaymentInfo(Payment payment) {
        return paymentDao.addPaymentInfo(payment);
    }

    @Override
    public Payment queryPaymentById(Long id) {
        return paymentDao.queryPaymentById(id);
    }
}


