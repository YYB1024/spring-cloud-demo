package com.study.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangyanbin
 * @since 20230602
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ZkProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZkProviderApplication.class,args);
    }
}
