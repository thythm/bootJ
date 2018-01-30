package com.momo.mq;

import com.alibaba.fastjson.JSONObject;
import com.momo.bean.bo.PhoneMessage;
import com.momo.service.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author majunjie
 * @description 发送短信消费者
 * @date 2017/10/25 14:43
 */
@Component
public class PhoneMessageCustomer {

    public static final Logger LOGGER = LoggerFactory.getLogger(PhoneMessageCustomer.class);

    @Autowired
    private RedisService redisService;

    /**
     * 从队列中取出信息，执行发送短信逻辑
     */
    public void pull(){

        while (true) {
            String json = redisService.rpop(QueueAndTopic.QUEUE_PHONE_MESSAGE);

            if (StringUtils.isBlank(json)) {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    LOGGER.error("短信队列线程睡眠异常", e);
                }
                continue;
            }

            PhoneMessage phoneMessage = JSONObject.parseObject(json, PhoneMessage.class);
            LOGGER.info("发送短信：" + phoneMessage);

        }
    }

}
