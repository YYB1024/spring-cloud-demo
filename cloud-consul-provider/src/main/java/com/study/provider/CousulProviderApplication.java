package com.study.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangyanbin
 * @since 20230605
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CousulProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CousulProviderApplication.class,args);
    }
}
