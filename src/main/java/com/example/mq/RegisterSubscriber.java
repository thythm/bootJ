package com.example.mq;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.bo.PhoneMessage;
import com.example.bean.entity.User;
import com.example.service.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author majunjie
 * @description 订阅注册（使用mq，异步处理、解耦）
 * @date 2017/10/24 16:48
 */
@Component
public class RegisterSubscriber {

    @Autowired
    private RedisService redisService;

    private final static Logger LOGGER = LoggerFactory.getLogger(RegisterSubscriber.class);

    /**
     *  注册后发送短信
     * @param message
     */
    public void subOne(String message){
        User user = JSONObject.parseObject(message, User.class);
        LOGGER.info(Thread.currentThread().getName() + "注册订阅一 <" + user + ">");

        PhoneMessage phoneMessage = new PhoneMessage();
        phoneMessage.setPhone(StringUtils.isBlank(user.getPhone())? "13777844021":user.getPhone());
        phoneMessage.setTitle("注册");
        phoneMessage.setContent("欢迎您加入momo");

        redisService.lpush(QueueAndTopic.QUEUE_PHONE_MESSAGE, phoneMessage);
    }

    /**
     *  注册后其他后续逻辑，赠送之类的
     * @param message
     */
    public void subTwo(String message){
        User user = JSONObject.parseObject(message, User.class);
        LOGGER.info(Thread.currentThread().getName() + "注册订阅二 <" + user + ">");
    }

}
