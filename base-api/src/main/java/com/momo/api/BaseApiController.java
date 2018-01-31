package com.momo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author majunjie
 * @date 2018/1/31 10:13
 */
@RestController
public class BaseApiController {

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public Object getName(){
        return "hello world!";
    }

}
