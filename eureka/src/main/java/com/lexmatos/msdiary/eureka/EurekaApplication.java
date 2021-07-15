package com.lexmatos.msdiary.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * https://spring.io/guides/gs/service-registration-and-discovery/
 * 
 * docker run -p 8761:8761 lexmatos/eureka:0.0.1-SNAPSHOT
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}
}
