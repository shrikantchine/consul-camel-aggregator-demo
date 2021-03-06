package com.shrikantchine.routes;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.dataformat.soap.name.ServiceInterfaceStrategy;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.dataformat.SoapJaxbDataFormat;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.shrikantchine.aggregation.OrderProductAccountAggregationStrategy;
import com.shrikantchine.models.AccountDetailsRequest;
import com.shrikantchine.models.AccountDetailsResponse;
import com.shrikantchine.models.CustomerDetailsRequest;
import com.shrikantchine.models.CustomerDetailsResponse;
import com.shrikantchine.models.OrderProductAccountRequest;
import com.shrikantchine.models.ProductDetailsResponse;
import com.shrikantchine.soap.orderdetailsservice.v1.ObjectFactory;
import com.shrikantchine.soap.orderdetailsservice.v1.OrderDetailsRequest;
import com.shrikantchine.soap.orderdetailsservice.v1.OrderDetailsResponse;
import com.shrikantchine.utils.Constants;
import com.shrikantchine.ws.OrderDetailsService;

@Component
@DependsOn("consulRegistration")
public class GatewayRoutesBuilder extends RouteBuilder {
	
	private static final String HTTP_POST_METHOD = "POST";
	private static final String REST_CONTENT_TYPE = "application/json";
	

	@Override
	public void configure() throws Exception {
		from("cxf:bean:orderProductAccountDetails")
			.multicast(new OrderProductAccountAggregationStrategy())
			.parallelProcessing()
			.to("direct:customerDetails", "direct:productDetails" , "direct:accountDetails", "direct:orderDetails")
			.end();
		
		customerDetailsRoute();
		productDetailsRoute();
		accountDetailsRoute();
		orderDetailsRoute();
	}

	private void customerDetailsRoute() {
		from("direct:customerDetails")
			.routeId(Constants.ROUTE_ID_CUSTOMER_DETAILS)
			.setProperty("route", simple("routeId"))
			.routeDescription("Route to retrieve customer details")
			.setHeader(Exchange.HTTP_METHOD, constant(HTTP_POST_METHOD))
			.setHeader("Content-Type", constant(REST_CONTENT_TYPE))
			.setHeader("Accept", constant(REST_CONTENT_TYPE))
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					CustomerDetailsRequest req = new CustomerDetailsRequest();
					MessageContentsList body = (MessageContentsList) exchange.getIn().getBody();
					req.setCustomerId(((OrderProductAccountRequest)body.get(0)).getCustomerId());
					exchange.getIn().setBody(req);
				}
			})
			.marshal()
				.json(JsonLibrary.Jackson)
			.serviceCall("customer-details", "http4:customer-details/customer?bridgeEndpoint=true")
			.unmarshal(new JacksonDataFormat(CustomerDetailsResponse.class));
	}

	private void accountDetailsRoute() {
		from("direct:accountDetails")
			.routeId(Constants.ROUTE_ID_ACCOUNT_DETAILS)
			.setProperty("route", simple("routeId"))
			.routeDescription("Route to retrieve customer details")
			.setHeader(Exchange.HTTP_METHOD, constant(HTTP_POST_METHOD))
			.setHeader("Content-Type", constant(REST_CONTENT_TYPE))
			.setHeader("Accept", constant(REST_CONTENT_TYPE))
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					AccountDetailsRequest req = new AccountDetailsRequest();
					MessageContentsList body = (MessageContentsList) exchange.getIn().getBody();
					req.setCustomerId(((OrderProductAccountRequest)body.get(0)).getCustomerId());
					exchange.getIn().setBody(req);
				}
			})
			.marshal()
				.json(JsonLibrary.Jackson)
			.log("${body}")
			.serviceCall("account-details", "http4:account-details/accounts?bridgeEndpoint=true")
			.unmarshal(new JacksonDataFormat(AccountDetailsResponse.class));
	}


	private void productDetailsRoute() {
		from("direct:productDetails")
			.routeId(Constants.ROUTE_ID_PRODUCT_DETAILS)
			.setProperty("route", simple("routeId"))
			.routeDescription("Route to retrieve customer details")
			.setHeader(Exchange.HTTP_METHOD, constant(HTTP_POST_METHOD))
			.setHeader("Content-Type", constant(REST_CONTENT_TYPE))
			.setHeader("Accept", constant(REST_CONTENT_TYPE))
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					AccountDetailsRequest req = new AccountDetailsRequest();
					MessageContentsList body = (MessageContentsList) exchange.getIn().getBody();
					req.setCustomerId(((OrderProductAccountRequest)body.get(0)).getCustomerId());
					exchange.getIn().setBody(req);
				}
			})
			.marshal()
				.json(JsonLibrary.Jackson)
			.serviceCall("product-details", "http4:product-details/products?bridgeEndpoint=true")
			.unmarshal(new JacksonDataFormat(ProductDetailsResponse.class));
	}

	private void orderDetailsRoute() {
		SoapJaxbDataFormat soapDF = new SoapJaxbDataFormat(
				ObjectFactory.class.getPackage().getName(), new ServiceInterfaceStrategy(OrderDetailsService.class, true));
		
		from("direct:orderDetails")
			.routeId(Constants.ROUTE_ID_ORDER_DETAILS)
			.setProperty("route", simple("routeId"))
			.routeDescription("Route to retrieve customer details")
			.setHeader("operationName", constant("getOrderDetails"))
			.setHeader("operationNamespace", constant("http://shrikantchine.com/soap/OrderDetailsService/v1"))
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					OrderDetailsRequest req = new OrderDetailsRequest();
					MessageContentsList body = (MessageContentsList) exchange.getIn().getBody();
					req.setCustomerId(((OrderProductAccountRequest)body.get(0)).getCustomerId());
					exchange.getIn().setBody(req);
				}
			})
			.marshal(soapDF)
			.serviceCall("order-details", "http4:order-details/services/orders?bridgeEndpoint=true")
			.unmarshal(soapDF);
	}


}
