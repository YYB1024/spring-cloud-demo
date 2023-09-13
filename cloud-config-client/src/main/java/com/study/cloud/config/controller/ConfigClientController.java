package com.study.cloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyanbin
 * @since 202309
 **/
@RestController
@RefreshScope
public class ConfigClientController
{
    /**
    * 读取配置文件内容
    */
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo()

    {
        return configInfo;
    }
}

