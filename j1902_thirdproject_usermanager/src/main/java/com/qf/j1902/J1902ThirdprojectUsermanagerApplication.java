package com.qf.j1902;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class J1902ThirdprojectUsermanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(J1902ThirdprojectUsermanagerApplication.class, args);
	}

}
