package com.poly.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.poly.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.repository.OrderDAO;
import com.poly.repository.OrderDetailDAO;
import com.poly.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderDAO odao;
	@Autowired
	AccountDAO accountDAO;

	@Override
	public List<Order> getAllOrder() {
		return odao.findAll();
	}

	@Override
	public Order create(Order order) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String username = auth.getName();
			order.setAddress(order.getAddress());
			order.setSdt(order.getSdt());
			order.setAccount(accountDAO.findByUsername(username));
			order.setOrderStatus(0);
			order.setNote(order.getNote());
			order.setTotal(order.getTotal());
			order.setCreatedDate(LocalDateTime.now());
			order.setUpdatedDate(LocalDateTime.now());
			return odao.save(order);
		}
		return null;
	}

	@Override
	public Order update(Order order) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String username = auth.getName();
			order.setAddress(order.getAddress());
			order.setSdt(order.getSdt());
			order.setAccount(accountDAO.findByUsername(username));
			order.setOrderStatus(0);
			order.setNote(order.getNote());
			order.setTotal(order.getTotal());
			order.setCreatedDate(LocalDateTime.now());
			order.setUpdatedDate(LocalDateTime.now());
			order.setFullname(order.getFullname());
			return odao.save(order);
		}
		return null;
	}

	@Override
	public Order findById(Integer id) {
		// TODO Auto-generated method stub
		return odao.findById(id).get();
	}
	@Override
	public List<Order> findByUsername(String username) {
		// TODO Auto-generated method stub
		return odao.findByUsername(username);
	}

	@Override
	public void delete(Integer id) {
		odao.deleteById(id);
	}


}
