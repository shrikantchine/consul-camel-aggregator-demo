package com.shrikantchine.aggregation;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.shrikantchine.models.AccountDetailsResponse;
import com.shrikantchine.models.CustomerDetailsResponse;
import com.shrikantchine.models.OrderProductAccountResponse;
import com.shrikantchine.models.ProductDetailsResponse;
import com.shrikantchine.soap.orderdetailsservice.v1.OrderDetailsResponse;
import com.shrikantchine.utils.Constants;

public class OrderProductAccountAggregationStrategy implements AggregationStrategy {

	private OrderProductAccountResponse response;
	
	@SuppressWarnings("unchecked")
	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		response = oldExchange == null ?
												new OrderProductAccountResponse() :
												(OrderProductAccountResponse) oldExchange.getIn().getBody();
		
		Object body = newExchange.getIn().getBody();
		String routeId = (String) newExchange.getProperty("route");
		if (isCustomerDetailsResponse(routeId, body)) aggregateCustomerDetails((CustomerDetailsResponse) body);
		if (isAccountDetailsResponse(routeId, body)) response.setAccountDetails((AccountDetailsResponse) body);
		if (isProductDetailsResponse(routeId, body)) response.setProductDetails((ProductDetailsResponse) body);
		if (isOrderDetailsResponse(routeId, body)) response.setOrderDetails((OrderDetailsResponse) body);
		newExchange.getOut().setBody(response);
		return newExchange;
	}
	

	private boolean isCustomerDetailsResponse(String routeId, Object body) {
		if (routeId == null) return false;
		return (routeId.equals(Constants.ROUTE_ID_CUSTOMER_DETAILS) && body instanceof CustomerDetailsResponse);
	}
	
	private void aggregateCustomerDetails(CustomerDetailsResponse res) {
		response.setCustomerId(res.getCustomerId());
		response.setFistName(res.getFistName());
		response.setLastName(res.getLastName());
		response.setAge(res.getAge());
	}

	
	private boolean isAccountDetailsResponse(String routeId, Object body) {
		if (routeId == null) return false;
		return (routeId.equals(Constants.ROUTE_ID_ACCOUNT_DETAILS) 
				&& body instanceof AccountDetailsResponse );
	}
	
	
	private boolean isProductDetailsResponse(String routeId, Object body) {
		if (routeId == null) return false;
		return (routeId.equals(Constants.ROUTE_ID_PRODUCT_DETAILS) 
				&& body instanceof ProductDetailsResponse);
	}

	@SuppressWarnings("rawtypes")
	private boolean isOrderDetailsResponse(String routeId, Object body) {
		if (routeId == null) return false;
		return (routeId.equals(Constants.ROUTE_ID_ORDER_DETAILS) 
				&& body instanceof OrderDetailsResponse);
	}

}
