package com.momo.mq;

import com.momo.bean.bo.PhoneMessage;
import com.momo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author majunjie
 * @description 发送短信生产者
 * @date 2017/10/25 14:43
 */
@Component
public class PhoneMessageProducer {

    @Autowired
    private RedisService redisService;

    /**
     *  推送到目的地
     * @param phoneMessage
     */
    public void push(PhoneMessage phoneMessage){
        redisService.lpush(QueueAndTopic.QUEUE_PHONE_MESSAGE, phoneMessage);
    }

}
