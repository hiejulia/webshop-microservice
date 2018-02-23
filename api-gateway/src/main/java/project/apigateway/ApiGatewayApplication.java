package project.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.venrog.example.microservices.onlineshop.gatewayservice.filter.ProductCatalogQueryFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//@EnableZuulProxy
//@EnableDiscoveryClient
//@EnableCircuitBreaker
//
//
//@EnableEurekaClient

public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public ProductCatalogQueryFilter productCatalogQueryFilter()
	{
		return new ProductCatalogQueryFilter();
	}
}
