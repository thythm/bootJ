package com.momo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author majunjie
 * @date 2018/1/31 10:14
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BaseApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApiApplication.class, args);
    }

}
