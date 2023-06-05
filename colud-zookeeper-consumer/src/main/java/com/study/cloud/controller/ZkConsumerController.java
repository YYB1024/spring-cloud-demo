package com.study.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * zk消费者控制器
 *
 * @author yangyanbin
 * @date 2023/06/05
 * @since 20230605
 */
@RestController
public class ZkConsumerController {

    public static final String INVOKE_URL = "http://cloud-zookeeper-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/zk")
    public String consumerInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/provider/zk", String.class);
        return result;
    }
}
