package com.lexmatos.msdiary.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.password.PasswordEncoder;

//https://mkyong.com/spring-boot/spring-boot-yaml-example/

@EnableEurekaClient
@SpringBootApplication
public class UserApplication /*implements CommandLineRunner*/ {
	
	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	/*
	 * Password: $2a$10$Gt1FmyaBBAJM53XJP1e8hODK8tGLy.qmFp5Q2QLOXOwBUAk0qFnE6
	 * 
	 * @Override public void run(String... args) throws Exception {
	 * System.out.println("Password: "+ passwordEncoder.encode("1q2w3e4r5t"));
	 * 
	 * }
	 */}
