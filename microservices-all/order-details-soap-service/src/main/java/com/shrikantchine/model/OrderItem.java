package com.shrikantchine.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder= {"orderId", "orderedProduct", "description"})
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItem {
	@XmlElement(required=true)
	private String orderId;
	
	@XmlElement(required=true)
	private String orderedProduct;
	
	@XmlElement(required=true)
	private String description;
	
	public OrderItem() {}
	
	public OrderItem(String orderId, String orderedProduct, String description) {
		this.orderId = orderId;
		this.orderedProduct = orderedProduct;
		this.description = description;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderedProduct() {
		return orderedProduct;
	}
	public void setOrderedProduct(String orderedProduct) {
		this.orderedProduct = orderedProduct;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
