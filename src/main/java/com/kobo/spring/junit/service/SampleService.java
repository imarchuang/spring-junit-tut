package com.kobo.spring.junit.service;

public interface SampleService {

	public String getOrderDescription();
	public String getOrderStringCode();
	public Order getOrder(int id);
	public Order createOrder(Order order);
	
	
}
