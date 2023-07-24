package com.study.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 装配置
 *
 * NONE：默认的，不显示任何日志；
 *
 * BASIC：仅记录请求方法、URL、响应状态码及执行时间；
 *
 * HEADERS：除了 BASIC 中定义的信息之外，还有请求和响应的头信息；
 *
 * FULL：除了 HEADERS 中定义的信息之外，还有请求和响应的正文及元数据。
 *
 * @author yangyanbin
 * @date 2023/07/19
 * @since 20230719
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
