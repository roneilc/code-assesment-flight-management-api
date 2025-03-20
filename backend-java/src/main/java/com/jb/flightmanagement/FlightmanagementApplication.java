package com.jb.flightmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jb.flightmanagement")
public class FlightmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightmanagementApplication.class, args);
	}

}
