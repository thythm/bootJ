package com.momo.controller;

import com.momo.goods.service.IGoodsBrandService;
import com.momo.mq.RegisterPublisher;
import com.momo.service.FeignApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
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
    IGoodsBrandService goodsBrandService;
    @Autowired
    private RegisterPublisher registerPublisher;
    @Autowired
    private FeignApi api;

    @Value("${luckyWords}")
    private String luckyWords;

    @RequestMapping(value = "/{name}")
    public String test(@PathVariable("name") String name) {

        System.out.println(Thread.currentThread().getName() + "success into test(), param=" + name);

//        User user = new User();
//        user.setName(name);

//        registerPublisher.publish(user);

        return "hello " + name;
    }

    @RequestMapping(value = "/ttt")
    public Object aaa() {
        return goodsBrandService.selectById(1);
    }

    @RequestMapping(value = "/luckyWords")
    public Object luckyWords() {
        return luckyWords;
    }

    @RequestMapping(value = "/feign")
    public Object feign() {
        return api.name();
    }

}
