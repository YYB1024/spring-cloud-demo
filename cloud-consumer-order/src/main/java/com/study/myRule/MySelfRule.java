package com.study.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangyanbin
 * @since 20230616
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        // 定义为随机（负载均衡算法）
        return new RandomRule();
    }
}
