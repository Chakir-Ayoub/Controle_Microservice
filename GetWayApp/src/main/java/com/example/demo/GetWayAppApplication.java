package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class GetWayAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetWayAppApplication.class, args);
	}
	
	@Bean
	public DiscoveryClientRouteDefinitionLocator routesDynamic
	(
		ReactiveDiscoveryClient reactiveDiscoveryClient,
		DiscoveryLocatorProperties discoveryLocatorProperties
	) {
		return new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient, discoveryLocatorProperties);
	}


}
