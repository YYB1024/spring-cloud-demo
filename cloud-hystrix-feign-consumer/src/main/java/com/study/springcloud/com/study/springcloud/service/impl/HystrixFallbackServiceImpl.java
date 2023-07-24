package com.study.springcloud.com.study.springcloud.service.impl;

import com.study.springcloud.com.study.springcloud.service.HystrixFeignService;
import org.springframework.stereotype.Service;

/**
 * 服务降级统一处理业务类
 * @author yangyanbin
 * @since 20230721
 **/
@Service
public class HystrixFallbackServiceImpl implements HystrixFeignService {
    /**
     * 付款信息好了-feign调用
     *
     * @param id id
     * @return {@link String}
     */
    @Override
    public String paymentInfoOK(Integer id) {
        return "服务调用失败，提示来自：HystrixFallbackServiceImpl---paymentInfoOK";
    }

    /**
     * 付款信息错误-feign调用
     *
     * @param id id
     * @return {@link String}
     */
    @Override
    public String paymentInfoError(Integer id) {
        return "服务调用失败，提示来自：HystrixFallbackServiceImpl---paymentInfoTimeOut";

    }
}
