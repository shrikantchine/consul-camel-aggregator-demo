package com.shrikantchine.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shrikantchine.ws.OrderDetailsServiceImpl;

@Configuration
public class EndpointConfig {
	
	@Bean(name = "cxf")
	public SpringBus springBus() {
		return new SpringBus();
	}
	
	@Bean
	public Endpoint endpoint() {
		EndpointImpl ep = new EndpointImpl(springBus(), new OrderDetailsServiceImpl());
		ep.publish("/orders");
		return ep;
	}
}
