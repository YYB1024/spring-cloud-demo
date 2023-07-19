package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yangyanbin
 * @since 20230509
 **/
@SpringBootApplication
@EnableEurekaServer
public class Eureka2Application7002 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka2Application7002.class, args);
    }
}
