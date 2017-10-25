package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DemoApplication {

	private final static Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) throws Exception{

		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

	}

}
