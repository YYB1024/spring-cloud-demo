package com.study.springcloud.service;


import com.study.springcloud.entities.Payment;

/**
 * @author yangyanbin
 * @since 20230413
 **/
public interface PaymentService {
    /**
     * 创建
     *
     * @param payment 付款
     * @return int
     */
    int create(Payment payment);


    /**
     * 通过id获取付款
     *
     * @param id id
     * @return {@link Payment}
     */
    Payment getPaymentById(Long id);
}
