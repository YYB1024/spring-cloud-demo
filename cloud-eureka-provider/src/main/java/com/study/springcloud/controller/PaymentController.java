package com.study.springcloud.controller;


import com.study.springcloud.entities.CommonResult;
import com.study.springcloud.entities.Payment;
import com.study.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yangyb
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result =  paymentService.create(payment);
        log.info("插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入结果成功,serverPort"+ serverPort,result);
        }else {
            return new CommonResult(444,"插入结果失败",null);
        }
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment =  paymentService.getPaymentById(id);
        log.info("******查询结果：{},payment");
        if(payment != null){
            return new CommonResult(200,"查询结果成功"+"\t服务端口"+serverPort,payment);
        }else {
            return new CommonResult(444,"查询结果失败,查询id"+id, null);
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("service = " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-TRADE");
        for (ServiceInstance instance : instances) {
            System.out.println("instance.getInstanceId() = " + instance.getInstanceId()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }


}
