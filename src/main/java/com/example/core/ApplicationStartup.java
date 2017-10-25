package com.example.core;

import com.example.Thread.ThreadPoolManager;
import com.example.mq.PhoneMessageCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author majunjie
 * @description Spring boot启动后执行一些特殊的业务（大部分是线程）
 * @date 2017/10/25 15:03
 */
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 可能会出现手动获取Spring容器bean对象的情况，所以这里保存一个spring容器上下文
     */
    public static ApplicationContext context;

    @Autowired
    private PhoneMessageCustomer messageCustomer;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        context = event.getApplicationContext();
        init();
    }

    public void init(){

        /**
         * 启动发送短信队列的线程
         */
        ThreadPoolManager.pool.execute( () -> messageCustomer.pull() );

    }

}
