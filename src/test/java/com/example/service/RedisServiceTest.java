package com.example.service;

import org.junit.Test;

/**
 * @author majunjie
 * @description
 * @date 2017/10/25 12:11
 */
public class RedisServiceTest extends BaseServiceTest<RedisService> {

    @Test
    public void valid(){
        service.rpop("queue:message");
    }


}
