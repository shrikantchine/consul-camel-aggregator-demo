package com.shrikantchine.consul;

import org.apache.camel.Exchange;
import org.apache.camel.ShutdownRunningTask;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConsulRoutes extends RouteBuilder {
	
	private static final String DIRECT_START = "direct:start";
	private static final String DIRECT_STOP = "direct:stop";
	private static final String CONTENT_TYPE = "application/json";
	private static final String HTTP_METHOD_PUT = "PUT";
	private static final String REGISTER_ENDPOINT = "/v1/agent/service/register";
	private static final String DEREGISTER_ENDPOINT = "/v1/agent/service/deregister/${header.id}";
	
	@Value("${consul.location}")
	private String consulLocation;

	@Override
	public void configure() throws Exception {
		from(DIRECT_START)
			.marshal()
			.json(JsonLibrary.Jackson)
			.setHeader(Exchange.HTTP_METHOD, constant(HTTP_METHOD_PUT))
			.setHeader(Exchange.CONTENT_TYPE, constant(CONTENT_TYPE))
			.to(consulLocation + REGISTER_ENDPOINT);
		from(DIRECT_STOP)
			.shutdownRunningTask(ShutdownRunningTask.CompleteAllTasks)
			.setHeader(Exchange.HTTP_METHOD, constant(HTTP_METHOD_PUT))
			.setHeader(Exchange.CONTENT_TYPE, constant(CONTENT_TYPE))
			.toD(consulLocation + DEREGISTER_ENDPOINT);
	}

}
