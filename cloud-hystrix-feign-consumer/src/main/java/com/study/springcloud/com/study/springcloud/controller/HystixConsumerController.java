package com.study.springcloud.com.study.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.study.springcloud.com.study.springcloud.service.HystrixFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * hystix消费者控制器
 *
 * @author yangyanbin
 * @date 2023/07/20
 * @since 20230720
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "providerGlobalFallbackMethond")
public class HystixConsumerController {

    @Resource
    private HystrixFeignService hystrixFeignService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String result = hystrixFeignService.paymentInfoOK(id);
        return result;
    }

    /**
     * 服务降级处理 默认统一方法使用注解@HystrixCommand
     * 特殊降级处理方法@HystrixCommand(fallbackMethod = "xxx)
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
   /* @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        String result = hystrixFeignService.paymentInfoError(id);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    /**
     * 全局fallbackMethod
     *
     * @return
     */
    public String providerGlobalFallbackMethond() {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }


}
