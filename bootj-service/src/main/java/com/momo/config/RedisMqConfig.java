package com.momo.config;

import com.momo.mq.QueueAndTopic;
import com.momo.mq.RegisterSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author majunjie
 * @description
 * @date 2017/10/24 16:47
 */
@Configuration
@EnableScheduling
public class RedisMqConfig {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        return redisTemplate;
    }

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, RegisterSubscriber registerSubscriber) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(registerListenerAdapter(registerSubscriber), new PatternTopic(QueueAndTopic.TOPIC_REGISTER));
        container.addMessageListener(registerListenerAdapter2(registerSubscriber), new PatternTopic(QueueAndTopic.TOPIC_REGISTER));

        return container;
    }

    @Bean
    @Autowired
    public MessageListenerAdapter registerListenerAdapter(RegisterSubscriber registerSubscriber) {
        return new MessageListenerAdapter(registerSubscriber, "subOne");
    }

    @Bean
    @Autowired
    public MessageListenerAdapter registerListenerAdapter2(RegisterSubscriber registerSubscriber) {
        return new MessageListenerAdapter(registerSubscriber, "subTwo");
    }

}
