package com.example.praticien_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PraticienServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PraticienServiceApplication.class, args);
	}

}
