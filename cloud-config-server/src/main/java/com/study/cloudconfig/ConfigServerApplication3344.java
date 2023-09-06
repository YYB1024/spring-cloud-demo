package com.study.cloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author yangyanbin
 * @since 20230906
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication3344.class,args);
    }
}
