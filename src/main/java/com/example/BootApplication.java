package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@EnableEurekaServer//发现服务
@SpringBootApplication
public class BootApplication {

	private final static Logger LOGGER = LoggerFactory.getLogger(BootApplication.class);

	public static void main(String[] args) throws Exception{

		ApplicationContext ctx = SpringApplication.run(BootApplication.class, args);
		System.out.println();

	}

}
