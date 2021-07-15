package com.lexmatos.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

	@Bean
	public RouteLocator getwayRouter(RouteLocatorBuilder builder ) {
		
		return builder.routes().route(p -> p.path("/get").uri("http://httpbin.org:80"))
								.route(f -> f.path("/users/**").uri("lb://user"))
								.route(f -> f.path("/diarys/**").uri("lb://diary"))
								.route(f -> f.path("/oauth/**").uri("lb://oauth"))
				.build();
	}
}
