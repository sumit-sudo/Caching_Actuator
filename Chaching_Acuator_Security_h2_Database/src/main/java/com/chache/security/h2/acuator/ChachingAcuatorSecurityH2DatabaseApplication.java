package com.chache.security.h2.acuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ChachingAcuatorSecurityH2DatabaseApplication {

	public static void main(String[] args) {
		System.out.println("DEV1 is working");
		System.out.println("DEV2 is working and made the changes, final changes");
		SpringApplication.run(ChachingAcuatorSecurityH2DatabaseApplication.class, args);
	}
	
}
