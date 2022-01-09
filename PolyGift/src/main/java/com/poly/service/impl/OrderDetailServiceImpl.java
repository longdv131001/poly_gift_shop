package com.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.entity.Product;
import com.poly.repository.OrderDAO;
import com.poly.repository.OrderDetailDAO;
import com.poly.repository.ProductDAO;
import com.poly.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	@Autowired
	private OrderDetailDAO orderDetailRepository;
	
	@Autowired
	private ProductDAO productRepository;
	
	@Autowired
	private OrderDAO orderRepository;
	
	@Override
	public List<OrderDetail> getAllOrderDetails() {
		return orderDetailRepository.findAll();
	}

	@Override
	public OrderDetail getById(Integer id) {
		return orderDetailRepository.findById(id).get();
	}

	@Override
	public OrderDetail createOrderDetail(OrderDetail orderDetail) {
		Optional<Order> order = orderRepository.findById(orderDetail.getOrder().getId());
		Optional<Product> product = productRepository.findById(orderDetail.getProduct().getId());
		if(order.isPresent() && product.isPresent()) {
			orderDetail.setOrder(order.get());
			orderDetail.setProduct(product.get());
			return orderDetailRepository.save(orderDetail);
		}
		return null;
	}

	@Override
	public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
		Optional<Order> order = orderRepository.findById(orderDetail.getOrder().getId());
		Optional<Product> product = productRepository.findById(orderDetail.getProduct().getId());
		if(order.isPresent() && product.isPresent()) {
			orderDetail.setOrder(order.get());
			orderDetail.setProduct(product.get());
			return orderDetailRepository.save(orderDetail);
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		orderDetailRepository.deleteById(id);
		
	}

	@Override
	public List<OrderDetail> getByOrderId(Integer id) {
		return orderDetailRepository.getByOrderId(id);
	}

}
