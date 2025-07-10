package com.smiling.buddah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class BuddahApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuddahApplication.class, args);
	}

}
