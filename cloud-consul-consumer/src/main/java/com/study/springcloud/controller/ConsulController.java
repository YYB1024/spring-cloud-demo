package com.study.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 领事控制器
 *
 * @author yangyanbin
 * @date 2023/06/05
 * @since 20230605
 */
@RestController
public class ConsulController {
    public static final String INVOKE_URL = "http://cloud-consul-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/consul")
    public String paymentInfo()
    {
        String result = restTemplate.getForObject(INVOKE_URL+"/provider/consul", String.class);
        System.out.println("消费者调用服务(consule)--->result:" + result);
        return result;
    }
}
