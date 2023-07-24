package com.study.springcloud.service;

/**
 * @author yangyanbin
 * @since 20230720
 **/
public interface PaymentService {
    /**
     * 付款信息好了
     *
     * @param id id
     * @return {@link String}
     */
    String paymentInfoOK(Integer id);

    /**
     * 付款信息错误
     *
     * @param id id
     * @return {@link String}
     */
    String paymentInfoError(Integer id);
}
