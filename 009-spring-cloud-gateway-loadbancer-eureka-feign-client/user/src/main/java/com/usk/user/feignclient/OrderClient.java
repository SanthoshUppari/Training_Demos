package com.usk.user.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(value="order-service", url="http://localhost:8081/demo/orders")
@FeignClient(name="http://ORDER-SERVICE/order/orders")
public interface OrderClient {
	
	@GetMapping("/port")
	public String getInfo();
	

}
