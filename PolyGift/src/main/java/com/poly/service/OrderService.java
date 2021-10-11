package com.poly.service;


import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.entity.Order;


public interface OrderService{

	Order create(JsonNode orderdata);

	Order findById(Long id);

	List<Order> findByUsername(String username);

}
