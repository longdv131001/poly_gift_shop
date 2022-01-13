package com.poly.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.poly.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.poly.entity.Order;
import com.poly.repository.OrderDAO;
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
			order.setAccount(accountDAO.findAccountByUsername(username));
			order.setOrderStatus(0);
			order.setTotal(order.getTotal());
			order.setCreatedDate(LocalDateTime.now());
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
			order.setAccount(accountDAO.findAccountByUsername(username));
			order.setTotal(order.getTotal());
			order.setCreatedDate(order.getCreatedDate());
			order.setUpdatedDate(LocalDateTime.now());
			order.setFullname(order.getFullname());
			return odao.save(order);
		}
		return null;
	}

	@Override
	public Order findById(Integer id) {
		return odao.findById(id).get();
	}
	@Override
	public List<Order> findByUsername(String username) {
		return odao.findByUsername(username);
	}

	@Override
	public void delete(Integer id) {
		odao.deleteById(id);
	}

	@Override
	public List<Order> findBySdt(String sdt) {
		return odao.findBySdt(sdt);
	}


}
