package com.study.cloud.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author yangyanbin
 * @since 20231017
 **/
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        // 暂停毫秒
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "-----testA";
    }
    @GetMapping("/testB")
    public String testB() {
        return "-----testB";
    }
}