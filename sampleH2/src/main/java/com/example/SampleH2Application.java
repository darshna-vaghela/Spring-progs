package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SampleH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SampleH2Application.class, args);
	}

}
