package com.usk.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.order.dto.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	Environment environment;

	@GetMapping("/port")
	public String getPortNo() {
		String port = environment.getProperty("local.server.port");
		return "From Order app : " + port;
	}

	static Map<String, List<Order>> userOrders = new HashMap<>();

	static {
		List<Order> orders = new ArrayList<>();

		Order order = new Order();
		order.setId(101);
		order.setDes("desc11");
		orders.add(order);

		order = new Order();
		order.setId(102);
		order.setDes("desc12");
		orders.add(order);

		userOrders.put("101", orders);

		orders = new ArrayList<>();

		order = new Order();
		order.setId(201);
		order.setDes("desc21");
		orders.add(order);

		order = new Order();
		order.setId(202);
		order.setDes("desc22");
		orders.add(order);

		userOrders.put("201", orders);
	}

	@GetMapping("")
	public Map<String, List<Order>> getAll() {
		return userOrders;
	}

	@GetMapping("/{userId}")
	public List<Order> getAllById(@PathVariable String userId) {
		return userOrders.get(userId);
	}

	@GetMapping("/byparam")
	public List<Order> getAllByReqParam(@RequestParam String userId) {
		return userOrders.get(userId);
	}

	@PostMapping("/byparam")
	public List<Order> getAllByPostReqParam(@RequestParam String userId) {
		return userOrders.get(userId);
	}

	@PostMapping("/{userId}")
	public List<Order> getAllByPostReqBody(@PathVariable String userId, @RequestBody Order order) {
		List<Order> orders = userOrders.get(userId);
		orders.add(order);
		userOrders.put(userId, orders);
		return userOrders.get(userId);
	}
}
