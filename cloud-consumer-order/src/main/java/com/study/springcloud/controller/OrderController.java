package com.study.springcloud.controller;

import com.study.springcloud.entities.CommonResult;
import com.study.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yangyanbin
 * @since 20230419
 **/
@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL="Http://localhost:8001";
    public static final String PAYMENT_URL="http://CLOUD-PROVIDER-TRADE";



    @Resource
    private RestTemplate restTemplate;

    /**
     * url, requestMap, ResponseBean.class
     * 这三个参数分别代表 :REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     * @param payment
     * @return
     */
    @GetMapping("/comsumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
        // return restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment,CommonResult.class).getBody();
    }

    @GetMapping("/comsumer/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
    }


    @GetMapping("/comsumer/payment/getPaymentById2/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败！");
        }
    }



}
