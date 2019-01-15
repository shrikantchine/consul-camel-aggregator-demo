package com.shrikantchine.config;

import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.cxf.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shrikantchine.gateway.ws.OrderProductAccountService;

@Configuration
public class EndpointConfiguration {
	
	@Autowired
	private Bus bus;
	
	@Bean(name="orderProductAccountDetails")
	public CxfEndpoint orderProductAccountDetails() {
		CxfEndpoint cxfEndpoint = new CxfEndpoint();
		cxfEndpoint.setAddress("/orderProductAccounts");
		cxfEndpoint.setBus(this.bus);
		cxfEndpoint.setServiceClass(OrderProductAccountService.class);
		return cxfEndpoint;
	}
}
