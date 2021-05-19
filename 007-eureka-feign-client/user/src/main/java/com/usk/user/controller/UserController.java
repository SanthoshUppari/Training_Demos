package com.usk.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.user.dto.OrderRequest;
import com.usk.user.dto.UserOrdersResponse;
import com.usk.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/port")
	public String getOrderServicePortNo() {
		return userService.getOrderServicePortNo();
	}

	@GetMapping("/{userId}/orders")
	public UserOrdersResponse getUserAndOrdersByUserIdPathvar(@PathVariable String userId) {
		return userService.getOrdersByUserId(userId);
	}

	@GetMapping("/orders")
	public UserOrdersResponse getUserAndOrdersByUserIdReqparam(@RequestParam String userId) {
		return userService.getAllByReqParam(userId);

	}

	@PostMapping("/orders")
	public UserOrdersResponse getUserAndOrdersByUserIdPost(@RequestParam String userId) {
		return userService.getAllByPostReqParam(userId);
	}

	@PostMapping("/{userId}/orders")
	public UserOrdersResponse updateUserOrders(@PathVariable String userId, @RequestBody OrderRequest order) {
		return userService.getUserOrders(userId, order);

	}
}
