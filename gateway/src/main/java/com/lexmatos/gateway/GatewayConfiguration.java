package com.lexmatos.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

/*	
	@Bean
	public RouteLocator getwayRouter(RouteLocatorBuilder builder ) {
		
		return builder.routes().route(f -> f.path("/get").uri("http://httpbin.org:80"))
								.route(f -> f.path("/user/**").uri("lb://user"))
								.route(f -> f.path("/diary/**").uri("lb://diary"))
								.route(f -> f.path("/oauth/**").uri("lb://oauth"))
				.build();
	}
	*/
}
