package com.momo.api;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author majunjie
 * @date 2018/2/1 11:07
 */
@Component
public class ProducerManage {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void publishDirect(){

        for (int i = 0; i < 5; i++) {
            User user = new User("momo" + i);
            System.out.println(Thread.currentThread().getName() + " Sender1 : " +user);
            this.rabbitTemplate.convertAndSend("user", user, (msg) -> {
                msg.getMessageProperties();
                return msg;
            });
        }
    }

    public void publishFanout(){
        for (int i = 0; i < 2; i++) {
            String msg = "hello world";
            System.out.println("sender : " + msg);
            this.rabbitTemplate.convertAndSend("fanoutExchange", "fanout.ee", msg);
        }
    }

}
