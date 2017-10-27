package com.example.controller;

import com.example.annotation.Valid;
import com.example.bean.entity.User;
import com.example.mq.RegisterPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author majunjie
 * @description
 * @date 2017/10/24 11:56
 */
@RestController
public class IndexController {

    private final static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private RegisterPublisher registerPublisher;

    @RequestMapping
    @Valid("呵呵")
    public String test(String name) {

        System.out.println(Thread.currentThread().getName() + "success into test(), param=" + name);

//        registerPublisher.publish(user);

        return name;
    }

}
