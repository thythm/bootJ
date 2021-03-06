package com.momo.service;

import com.momo.BootApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author majunjie
 * @description 基类，省去重复代码
 * @date 2017/10/25 12:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { BootApplication.class })
public class BaseServiceTest<S> {

    @Autowired
    S service;

}
