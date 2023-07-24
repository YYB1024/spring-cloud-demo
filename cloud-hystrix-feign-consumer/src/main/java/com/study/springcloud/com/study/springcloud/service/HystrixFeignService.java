package com.study.springcloud.com.study.springcloud.service;

import com.study.springcloud.com.study.springcloud.service.impl.HystrixFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yangyanbin
 * @since 20230720
 **/
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PROVIDER",fallback = HystrixFallbackServiceImpl.class)
public interface HystrixFeignService {

    /**
     * 付款信息好了-feign调用
     *
     * @param id id
     * @return {@link String}
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOK(@PathVariable("id") Integer id);

    /**
     * 付款信息错误-feign调用
     *
     * @param id id
     * @return {@link String}
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoError(@PathVariable("id") Integer id);
}
