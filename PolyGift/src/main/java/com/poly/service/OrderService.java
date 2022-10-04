package com.poly.service;


import com.poly.request.OrderRequest;
import com.poly.response.OrderResponse;

import java.util.List;


public interface OrderService{

	List<OrderResponse> getAllOrder();

	OrderResponse create(OrderRequest request);

	OrderResponse update(int id, OrderRequest request);

	OrderResponse findById(Integer id);

	void delete(Integer id);

	List<OrderResponse> findByPhoneNumber(String phoneNumber);
}
