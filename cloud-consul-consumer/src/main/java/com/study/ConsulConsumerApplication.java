package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 领事使用者应用程序
 *
 * @author yangyanbin
 * @date 2023/06/05
 * @since 20230605
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerApplication.class,args);
    }
}
