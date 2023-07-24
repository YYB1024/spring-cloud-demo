package com.study.springcloud.service;

import com.study.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 付款服务
 *
 * 业务逻辑接口 + @FeignClient("CLOUD-PROVIDER-TRADE") 配置调用provider服务
 * CLOUD-PROVIDER-TRADE: eureka注册的服务名称
 *
 * @author yangyanbin
 * @date 2023/07/19
 * @since 20230719
 */
@Component
@FeignClient("CLOUD-PROVIDER-TRADE")
public interface PaymentFeignService {
    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeOut();
}
