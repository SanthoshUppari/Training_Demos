package com.usk.user.dto;

import java.util.ArrayList;
import java.util.List;

public class UserOrdersResponse {
	
	private User user = new User();
	
	private List<OrderResponse> orders = new ArrayList<>();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderResponse> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderResponse> orders) {
		this.orders = orders;
	}

	

}
