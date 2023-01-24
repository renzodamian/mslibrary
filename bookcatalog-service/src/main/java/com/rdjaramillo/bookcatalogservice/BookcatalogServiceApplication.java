package com.rdjaramillo.bookcatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookcatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookcatalogServiceApplication.class, args);
	}

}
