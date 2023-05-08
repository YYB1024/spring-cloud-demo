package com.study.springcloud.controller;


import com.study.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yangyanbin
 * @since 20230413
 **/
@RestController
@Slf4j
public class PayMentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
       int result =  paymentService.create(payment);
       log.info("插入结果："+result);
       if(result > 0){
           return new CommonResult(200,"插入结果成功",result);
       }else {
           return new CommonResult(444,"插入结果失败",null);
       }
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment =  paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"查询结果成功",payment);
        }else {
            return new CommonResult(444,"查询结果失败", null);
        }
    }


}
