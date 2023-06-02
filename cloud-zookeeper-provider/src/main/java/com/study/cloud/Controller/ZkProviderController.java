package com.study.cloud.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author yangyanbin
 * @since 20230602
 **/
@RestController
@Slf4j
public class ZkProviderController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/provider/zk")
    public String zkServer(){
        return "springcloud with zookeeper:" +serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
