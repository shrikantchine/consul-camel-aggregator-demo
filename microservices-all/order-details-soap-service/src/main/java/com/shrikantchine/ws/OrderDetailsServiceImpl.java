package com.shrikantchine.ws;

import javax.jws.WebService;

import com.shrikantchine.data.OrderDetailsDAO;
import com.shrikantchine.model.OrderDetailsRequest;
import com.shrikantchine.model.OrderDetailsResponse;

@WebService(endpointInterface="com.shrikantchine.ws.OrderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Override
	public OrderDetailsResponse getOrderDetails(OrderDetailsRequest request) {
		return OrderDetailsDAO.getInstance().getOrderDetails(request);
	}

}
