package com.momo.service;

import com.alibaba.fastjson.JSONObject;
import com.momo.annotation.Valid;
import com.momo.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author majunjie
 * @description redis相关操作
 * @date 2017/10/25 10:35
 */
@Service
@Valid
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, Object obj){
        redisTemplate.opsForValue().set(key, JSONObject.toJSONString(obj));
    }

    public void lpush(String key, Object obj){
        stringRedisTemplate.opsForList().leftPush(key, JSONObject.toJSONString(obj));
    }

    public void lpush(String key, String value){
        stringRedisTemplate.opsForList().leftPush(key, value);
    }

    public String rpop(String key){
        return stringRedisTemplate.opsForList().rightPop(key);
    }

    public void set(String key, String value, int countDown, TimeUnit timeUnit){
        stringRedisTemplate.opsForValue().set(key, value, countDown, timeUnit);
    }

    public void set(String key, Object obj, int countDown, TimeUnit timeUnit){
        set(key, JSONObject.toJSONString(obj), countDown, timeUnit);
    }

    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     *  用于mq发布消息
     * @param topic 主题
     * @param obj 消息对象（会被序列化）
     * @author majunjie
     * @date 2017/10/25 10:43
     * @since 1.0
     */
    public void publish(String topic, Object obj){
        redisTemplate.convertAndSend(topic, obj);
    }

    public void preCheck(String key, String value){
        Assert.notBlank(key, "key不能为空！");
        Assert.notBlank(value, "value不能为空！");
    }

    public void preCheck(String key, Object obj){
        Assert.notBlank(key, "key不能为空！");
        Assert.notNull(obj, "value不能为空！");
    }

    public void checkCountDown(int countDown){
        Assert.isTrue(countDown > 0, "使用该方法必须设置key的存活时间！");
    }

}
