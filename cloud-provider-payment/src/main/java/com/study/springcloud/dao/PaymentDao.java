package com.study.springcloud.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangyanbin
 * @since 20230412
 **/
@Mapper
public interface PaymentDao {
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
    Payment getPaymentById(@Param("id") Long id);
}
