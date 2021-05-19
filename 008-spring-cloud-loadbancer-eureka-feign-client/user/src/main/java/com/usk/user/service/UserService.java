package com.usk.user.service;

import com.usk.user.dto.OrderRequest;
import com.usk.user.dto.UserOrdersResponse;

public interface UserService {

	String getOrderServicePortNo();

	UserOrdersResponse getOrdersByUserId(String userId);

	UserOrdersResponse getAllByReqParam(String userId);

	UserOrdersResponse getAllByPostReqParam(String userId);

	UserOrdersResponse getUserOrders(String userId, OrderRequest order);

}
