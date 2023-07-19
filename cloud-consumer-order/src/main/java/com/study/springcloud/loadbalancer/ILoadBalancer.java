package com.study.springcloud.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author yangyanbin
 * @since 20230719
 **/
public interface ILoadBalancer {

    /**
     * 收集eureka上存活的机器（服务发现）
     *
     * @param instanceList 实例列表
     * @return {@link ServiceInstance}
     */
    ServiceInstance instances(List<ServiceInstance> instanceList);

}
