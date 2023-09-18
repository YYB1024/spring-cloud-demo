package com.study.cloud.consumer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author yangyanbin
 * @since 20230918
 **/
@Component
// 指信道**channe/和exchange绑定**在一起
@EnableBinding(Sink.class)
public class ReceviceMessageListener {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者2号，消息message = " + message.getPayload()+"\t port:"+serverPort);

    }
}
