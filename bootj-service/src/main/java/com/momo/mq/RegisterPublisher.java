package com.momo.mq;

import com.momo.bean.entity.User;
import com.momo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author majunjie
 * @description 注册成功后发布消息
 * @date 2017/10/25 10:20
 */
@Component
public class RegisterPublisher {

    @Autowired
    private RedisService redisService;

    public void publish(User user){
        redisService.publish(QueueAndTopic.TOPIC_REGISTER, user);
    }

}
