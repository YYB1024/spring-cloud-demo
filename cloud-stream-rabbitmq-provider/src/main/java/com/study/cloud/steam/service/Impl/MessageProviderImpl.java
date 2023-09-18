package com.study.cloud.steam.service.Impl;

import com.study.cloud.steam.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author yangyanbin
 * @since 20230918
 **/
// 可以理解为是一个消息的发送管道的定义
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息的发送管道
     */
    @Resource
    private MessageChannel output;

    /**
     * 消息发送
     *
     * @return {@link String}
     */
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***serial: "+serial);
        return serial;
    }
}
