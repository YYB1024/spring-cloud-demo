package com.study.springcloud.loadbalancer.impl;

import com.study.springcloud.loadbalancer.ILoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangyanbin
 * @since 20230719
 **/
@Service
public class ILoadBalancerImpl implements ILoadBalancer {

    /**
     * 原子整数
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("第几次访问的次数next = " + next);

        return next;
    }


    /**
     * 收集eureka上存活的机器（服务发现）
     *
     * 算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标 （每次服务重启动后rest接口计数从1开始）
     * @param instanceList 实例列表
     * @return {@link ServiceInstance}
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> instanceList) {
        int index = getAndIncrement() % instanceList.size();
        return instanceList.get(index);
    }
}
