package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yangyanbin
 * @since 20230412
 **/
@EnableEurekaClient
@SpringBootApplication
public class Trade2Application {
    public static void main(String[] args) {
        SpringApplication.run(Trade2Application.class,args);
    }
}
