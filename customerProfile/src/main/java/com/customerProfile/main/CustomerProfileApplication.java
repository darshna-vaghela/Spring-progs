package com.customerProfile.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = { "com.customerProfile" })
public class CustomerProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerProfileApplication.class, args);
	
	}

}
