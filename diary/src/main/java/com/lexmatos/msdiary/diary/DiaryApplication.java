package com.lexmatos.msdiary.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//http://localhost:34017/diarys/complete/1
//https://dzone.com/articles/resilience4j-intro
//https://www.youtube.com/results?search_query=resilience4j

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class DiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiaryApplication.class, args);
	}
}
