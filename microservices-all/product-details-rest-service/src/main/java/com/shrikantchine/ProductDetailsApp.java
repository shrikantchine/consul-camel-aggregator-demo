package com.shrikantchine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:consul-config.properties")
public class ProductDetailsApp {

	public static void main(String[] args) {
		SpringApplication.run(ProductDetailsApp.class, args);
	}

}
