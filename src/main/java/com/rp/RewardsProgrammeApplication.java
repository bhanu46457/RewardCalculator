package com.rp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rp.controllers","com.rp.service"})
public class RewardsProgrammeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardsProgrammeApplication.class, args);
	}

}
