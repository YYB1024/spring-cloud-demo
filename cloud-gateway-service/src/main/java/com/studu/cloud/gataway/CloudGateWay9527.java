package com.studu.cloud.gataway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yangyanbin
 * @since 20230830
 **/
@EnableEurekaClient
@SpringBootApplication
public class CloudGateWay9527 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateWay9527.class,args);
    }
}
