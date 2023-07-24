package com.study.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.study.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author yangyanbin
 * @since 20230720
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 付款信息好了
     *
     * @param id id
     * @return {@link String}
     */
    @Override
    public String paymentInfoOK(Integer id) {
        return "线程池："+ Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O哈哈~";
    }

    /**
     * 付款信息错误
     *
     * 解决上层服务调用延时或者失败的问题：使用服务降级的理念-fallback
     *  1、在业务类方法级别的使用注解 @HystrixCommand
     *  -- fallbackMethod: 处理服务不可用时的结果【当前服务不可用了，做服务降级，兜底的方案】
     *  -- commandProperties :多个配置熔断策略（数组形式）
     *      ---@HystrixProperty 具体的熔断策略eg: 可以设置超时时间(如果服务响应超过3s则采用兜底方案)
     *  2、在启动类上激活 @EnableCircuitBreaker
     * @param id id
     * @return {@link String}
     */
    @HystrixCommand(fallbackMethod = "paymentInfoErrorHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @Override
    public String paymentInfoError(Integer id) {
        int timeNumer = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+ Thread.currentThread().getName()+"paymentInfoError,id: "+id+"\t"+"O(∩_∩)O哈哈~,耗时"+"s";

    }

    public String paymentInfoErrorHandler(Integer id){
        return "/(ToT)/调用支付接口超时或异常：\t"+"\t当前线程池名字" + Thread.currentThread().getName();
    }



    //==============================服务熔断========================================

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),// 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
