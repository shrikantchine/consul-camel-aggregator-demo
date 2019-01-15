package com.shrikantchine.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrderDetailsResponse {
	
	private List<OrderItem> orderItem;
	
	public OrderDetailsResponse() {}

	public OrderDetailsResponse(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	} 
	
	
}

