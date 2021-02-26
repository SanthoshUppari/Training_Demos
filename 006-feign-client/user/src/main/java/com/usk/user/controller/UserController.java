package com.usk.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.user.dto.OrderResponse;
import com.usk.user.dto.User;
import com.usk.user.dto.UserOrdersResponse;
import com.usk.user.feignclient.OrderClient;

@RestController
@RequestMapping("/users")
public class UserController {

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

	@GetMapping("/port")
	public String getPortNo() {
		return orderClient.getPortNo();
	}

	@GetMapping("/{userId}")
	public UserOrdersResponse getOrdersByUserId(@PathVariable String userId) {
		User user = userDetails.get(userId);

		List<OrderResponse> orders = orderClient.getOrdersByUserId(userId);

		UserOrdersResponse userOrdersResponse = new UserOrdersResponse();
		userOrdersResponse.setUser(user);
		userOrdersResponse.setOrders(orders);
		return userOrdersResponse;

	}

	@GetMapping("/getbyparam")
	public UserOrdersResponse getAllByReqParam(@RequestParam String userId) {
		User user = userDetails.get(userId);

		List<OrderResponse> orders = orderClient.getAllByReqParam(userId);

		UserOrdersResponse userOrdersResponse = new UserOrdersResponse();
		userOrdersResponse.setUser(user);
		userOrdersResponse.setOrders(orders);
		return userOrdersResponse;

	}

	@GetMapping("/postbyparam")
	public UserOrdersResponse getAllByPostReqParam(@RequestParam String userId) {
		User user = userDetails.get(userId);

		List<OrderResponse> orders = orderClient.getAllByPostReqParam(userId);

		UserOrdersResponse userOrdersResponse = new UserOrdersResponse();
		userOrdersResponse.setUser(user);
		userOrdersResponse.setOrders(orders);
		return userOrdersResponse;

	}

	@PostMapping("/{userId}")
	public UserOrdersResponse getUserOrders(@PathVariable String userId) {
		User user = userDetails.get(userId);

		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setId(103);
		orderResponse.setDes("new order");

		List<OrderResponse> orders = orderClient.getAllByPostReqBody(userId, orderResponse);

		UserOrdersResponse userOrdersResponse = new UserOrdersResponse();
		userOrdersResponse.setUser(user);
		userOrdersResponse.setOrders(orders);
		return userOrdersResponse;

	}
}
