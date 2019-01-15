package com.shrikantchine.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.shrikantchine.model.OrderDetailsRequest;
import com.shrikantchine.model.OrderDetailsResponse;
import com.shrikantchine.model.OrderItem;

public class OrderDetailsDAO {
	
	private static OrderDetailsDAO orderDetailsDAO;
	
	public Map<String, OrderDetailsResponse> customerToOrdersMap;
	
	private OrderDetailsDAO() {
		customerToOrdersMap = new HashMap<>();
		customerToOrdersMap.put("111", new OrderDetailsResponse(Arrays.asList(new OrderItem("ord-1", "Apple iMac", "Desktop computer for living room"),
																			  new OrderItem("ord-2", "Hyundai Accent", "Car for wife"))));
		customerToOrdersMap.put("222", new OrderDetailsResponse(Arrays.asList(new OrderItem("ord-1", "Thinkpad", "Desktop computer for living room"),
				  															  new OrderItem("ord-2", "Hyundai i20", "Car for wife"))));
	}
	
	public static synchronized OrderDetailsDAO getInstance() {
		return orderDetailsDAO == null ? new OrderDetailsDAO() : orderDetailsDAO;
	}
	
	public OrderDetailsResponse getOrderDetails(OrderDetailsRequest request) {
		OrderDetailsResponse orderDetails = customerToOrdersMap.get(request.getCustomerId());
		return orderDetails == null ? new OrderDetailsResponse() : orderDetails;
	}

}
