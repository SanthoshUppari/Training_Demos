package com.usk.user.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.usk.user.dto.OrderRequest;
import com.usk.user.dto.OrderResponse;

//@FeignClient(value = "order-service", url = "http://localhost:8082/order/orders")
@FeignClient(name = "http://ORDER-SERVICE/order/orders")
public interface OrderClient {
	
	@GetMapping("/port")
	public String getPortNo();
	
	@GetMapping("")
	public List<OrderResponse> getOrdersByUserId();
	
	@GetMapping("/{userId}")
	public List<OrderResponse> getOrdersByUserId(@PathVariable String userId); 
	
	@GetMapping("/byparam")
	public List<OrderResponse> getAllByReqParam(@RequestParam String userId);
	
	@PostMapping("/byparam")
	public List<OrderResponse> getAllByPostReqParam(@RequestParam String userId);
	
	@PostMapping("/{userId}")
	public List<OrderResponse> getAllByPostReqBody(@PathVariable String userId, @RequestBody OrderRequest order);

}
