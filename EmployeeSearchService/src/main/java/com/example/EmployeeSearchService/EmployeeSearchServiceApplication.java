package com.example.EmployeeSearchService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//https://dzone.com/articles/buiding-microservice-using-spring-boot-and-docker?fromrel=true
@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSearchServiceApplication.class, args);
	}

}

