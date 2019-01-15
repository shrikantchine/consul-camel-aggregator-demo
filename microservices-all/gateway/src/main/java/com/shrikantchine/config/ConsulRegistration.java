package com.shrikantchine.config;

import javax.annotation.PostConstruct;

import org.apache.camel.CamelContext;
import org.apache.camel.component.consul.ConsulConfiguration;
import org.apache.camel.component.consul.cloud.ConsulServiceDiscovery;
import org.apache.camel.model.cloud.ServiceCallConfigurationDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsulRegistration {
	
	@Autowired
	private CamelContext context;
	
	@Value("${consul.location}")
	private String consulURL;

	@PostConstruct
	public void initConsul() throws Exception {
		ServiceCallConfigurationDefinition config = new ServiceCallConfigurationDefinition();
		ConsulConfiguration consulConfig = new ConsulConfiguration();
		consulConfig.setUrl(consulURL);
		ConsulServiceDiscovery consulServiceDiscovery = new ConsulServiceDiscovery(consulConfig);
		config.setServiceDiscovery(consulServiceDiscovery);
		context.setServiceCallConfiguration(config);
	}
	
}
