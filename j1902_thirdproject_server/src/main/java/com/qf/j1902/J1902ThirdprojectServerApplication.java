package com.qf.j1902;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class J1902ThirdprojectServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(J1902ThirdprojectServerApplication.class, args);
	}

}
