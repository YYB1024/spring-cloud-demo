package com.study.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangyanbin
 * @since 20230419
 **/
@Configuration
public class ApplicationContextConfig {

    // 定义默认的负载均衡机制（使用@LoadBalanced注解赋予RestTemplate负载均衡的能力）
    // @LoadBalanced(自定义负载均衡算法需要去掉)
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
