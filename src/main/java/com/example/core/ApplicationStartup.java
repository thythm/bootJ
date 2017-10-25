package com.example.core;

import com.example.Thread.ThreadPoolManager;
import com.example.mq.PhoneMessageCustomer;
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

    public static ApplicationContext context;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        context = event.getApplicationContext();
        init();
    }

    public void init(){

        //
        ThreadPoolManager.pool.execute( () -> {
            PhoneMessageCustomer customer = context.getBean(PhoneMessageCustomer.class);
            customer.pull();
        });

    }

}
