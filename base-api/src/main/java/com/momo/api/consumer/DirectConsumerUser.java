package com.momo.api.consumer;

import com.momo.api.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author majunjie
 * @date 2018/2/1 11:07
 */
@Component
@RabbitListener(queues = "user")
public class DirectConsumerUser {

    @RabbitHandler
    public void process(User user) {
        System.out.println(Thread.currentThread().getName() + " Receiver1  : " + user);
    }

}
