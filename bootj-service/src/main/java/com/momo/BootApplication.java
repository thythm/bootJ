package com.momo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.momo.*.dao")
@SpringBootApplication

public class BootApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(BootApplication.class, args);
	}

}
