package com.poly.service.impl;

import com.poly.config.exception.AppException;
import com.poly.entity.Account;
import com.poly.entity.Order;
import com.poly.repository.AccountRepository;
import com.poly.repository.OrderRepository;
import com.poly.request.OrderRequest;
import com.poly.response.OrderResponse;
import com.poly.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	private final AccountRepository accountRepository;

	private final ModelMapper mapper;

	@Override
	public List<OrderResponse> getAllOrder() {
		return orderRepository.findAll()
				.stream()
				.map(order -> mapper.map(order, OrderResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public OrderResponse create(OrderRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String username = auth.getName();
			Account account = accountRepository.findAccountByUsername(username);
			Order order = orderRepository.save(Order.builder()
					.account(account)
					.address(request.getAddress())
					.city(request.getCity())
					.districts(request.getDistricts())
					.fee(request.getFee())
					.noteCustomer(request.getNoteCustomer())
					.orderCode(request.getOrderCode())
					.createdDate(request.getCreatedDate())
					.orderStatus(request.getOrderStatus())
					.phoneNumber(request.getPhoneNumber())
					.total(request.getTotal())
					.wards(request.getWards())
					.updatedDate(request.getUpdatedDate())
					.build());
			return mapper.map(order, OrderResponse.class);
		} else {
			throw new AppException("User not login", 401);
		}
	}

	@Override
	public OrderResponse update(int id, OrderRequest request) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new AppException("Order not found", 404));
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String username = auth.getName();
			order.setAddress(request.getAddress());
			order.setPhoneNumber(request.getPhoneNumber());
			order.setAccount(accountRepository.findAccountByUsername(username));
			order.setTotal(request.getTotal());
			order.setCreatedDate(request.getCreatedDate());
			order.setUpdatedDate(LocalDateTime.now());
			order.setFullName(request.getFullName());
			orderRepository.save(order);
			return mapper.map(order, OrderResponse.class);
		} else {
			throw new AppException("User not login", 401);
		}
	}

	@Override
	public OrderResponse findById(Integer id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new AppException("Order not found", 404));
		return mapper.map(order, OrderResponse.class);
	}

	@Override
	public void delete(Integer id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new AppException("Order not found", 404));
		orderRepository.delete(order);
	}

	@Override
	public List<OrderResponse> findByPhoneNumber(String phoneNumber) {
		return orderRepository.findByPhoneNumber(phoneNumber)
				.stream()
				.map(order -> mapper.map(order, OrderResponse.class))
				.collect(Collectors.toList());
	}


}
