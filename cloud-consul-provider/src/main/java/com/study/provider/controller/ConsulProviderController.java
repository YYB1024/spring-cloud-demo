package com.study.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 领事提供者控制器
 *
 * @author yangyanbin
 * @date 2023/06/05
 * @since 20230605
 */
@RestController
public class ConsulProviderController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/provider/consul")
    public String zkServer(){
        return "springcloud with consul:" +serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
