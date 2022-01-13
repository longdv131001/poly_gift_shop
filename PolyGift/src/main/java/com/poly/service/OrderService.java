package com.poly.service;


import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.entity.Order;


public interface OrderService{

	List<Order> getAllOrder();

	Order create(Order order);

	Order update(Order order);

	Order findById(Integer id);

	List<Order> findByUsername(String username);

	void delete(Integer id);

	List<Order>  findBySdt(String sdt);
}
