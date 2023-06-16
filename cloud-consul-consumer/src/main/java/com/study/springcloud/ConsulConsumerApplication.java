package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 领事使用者应用程序
 *
 * @author yangyanbin
 * @date 2023/06/05
 * @since 20230605
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient("")
public class ConsulConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerApplication.class,args);
    }
}
