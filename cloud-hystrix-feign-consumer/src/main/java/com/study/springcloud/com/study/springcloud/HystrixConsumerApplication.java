package com.study.springcloud.com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * hystrix使用者应用程序
 *
 * @author yangyanbin
 * @date 2023/07/20
 * @since 20230720
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixConsumerApplication.class,args);
    }
}
