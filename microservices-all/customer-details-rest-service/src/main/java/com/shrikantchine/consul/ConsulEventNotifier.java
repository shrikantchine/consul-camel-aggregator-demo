package com.shrikantchine.consul;

import java.util.EventObject;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.management.event.CamelContextStartedEvent;
import org.apache.camel.management.event.CamelContextStoppingEvent;
import org.apache.camel.support.EventNotifierSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConsulEventNotifier extends EventNotifierSupport {
	
	@Value("${server.port}")
	private int serverPort;
	
	@Value("${spring.application.name}")
	private String applicationName;


	@Override
	public void notify(EventObject event) throws Exception {
		if (event instanceof CamelContextStartedEvent) {
			CamelContext context = ((CamelContextStartedEvent) event).getContext();
			ProducerTemplate t = context.createProducerTemplate();
			t.sendBody("direct:start", new ConsulRegisterPayload(applicationName +"-" + serverPort, applicationName, "127.0.0.1", serverPort));
		}
		if (event instanceof CamelContextStoppingEvent) {
			CamelContext context = ((CamelContextStoppingEvent) event).getContext();
			ProducerTemplate t = context.createProducerTemplate();
			t.sendBodyAndHeader("direct:stop", null, "id", applicationName +"-" + serverPort);
		}
	}

	@Override
	public boolean isEnabled(EventObject event) {
		return (event instanceof CamelContextStartedEvent || event instanceof CamelContextStoppingEvent);
	}

}
