package com.momo.api.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author majunjie
 * @date 2018/2/1 11:07
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutConsumerB {

    @RabbitHandler
    public void process(String msg) {
        System.out.println(Thread.currentThread().getName() + " ReceiverB  : " + msg);
    }

}
