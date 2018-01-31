package com.momo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author majunjie
 * @description
 * @date 2017/10/24 11:56
 */
@FeignClient("BASE-API")
public interface FeignApi {

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    String name();

}
