package com.usk.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.usk.user.dto.OrderRequest;
import com.usk.user.dto.OrderResponse;
import com.usk.user.dto.User;
import com.usk.user.dto.UserOrdersResponse;
import com.usk.user.feignclient.OrderClient;
import com.usk.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	OrderClient orderClient;

	static Map<String, User> userDetails = new HashMap<>();

	static {

		User user = new User();
		user.setUserId("101");
		user.setUserName("Test1");

		userDetails.put("101", user);

		user = new User();
		user.setUserId("201");
		user.setUserName("Test2");

		userDetails.put("201", user);

	}

	
	@Override
	public String getOrderServicePortNo() {
		return orderClient.getPortNo();
	}

	@Override
	public UserOrdersResponse getOrdersByUserId(String userId) {
		User user = userDetails.get(userId);

		UserOrdersResponse userOrdersResponse = new UserOrdersResponse();
		userOrdersResponse.setUser(user);
		List<OrderResponse> userOrders = orderClient.getOrdersByUserId(userId);
		userOrdersResponse.setOrders(userOrders);
		return userOrdersResponse;

	}

	@Override
	public UserOrdersResponse getAllByReqParam(String userId) {
		User user = userDetails.get(userId);


		UserOrdersResponse userOrdersResponse = new UserOrdersResponse();
		userOrdersResponse.setUser(user);
		userOrdersResponse.setOrders(orderClient.getAllByReqParam(userId));
		
		return userOrdersResponse;

	}

	@Override
	public UserOrdersResponse getAllByPostReqParam(@RequestParam String userId) {
		User user = userDetails.get(userId);

		List<Object> orders = null;

		UserOrdersResponse userOrdersResponse = new UserOrdersResponse();
		userOrdersResponse.setUser(user);
		userOrdersResponse.setOrders(orderClient.getAllByPostReqParam(userId));
		return userOrdersResponse;

	}

	@Override
	public UserOrdersResponse getUserOrders(String userId, OrderRequest order) {
		User user = userDetails.get(userId);

		UserOrdersResponse userOrdersResponse = new UserOrdersResponse();
		userOrdersResponse.setUser(user);
		userOrdersResponse.setOrders(orderClient.getAllByPostReqBody(userId, order));
		return userOrdersResponse;

	}
}
