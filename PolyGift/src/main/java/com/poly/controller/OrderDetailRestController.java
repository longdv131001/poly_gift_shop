package com.poly.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dto.OrderDetailDto;
import com.poly.entity.OrderDetail;
import com.poly.service.OrderDetailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderdetails")
public class OrderDetailRestController {
	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<OrderDetailDto> getAllOrderDetail(){
		return orderDetailService.getAllOrderDetails().stream().map(o -> modelMapper.map(o, OrderDetailDto.class)).collect(Collectors.toList());
	}
	
	@PostMapping("{id}")
	public OrderDetailDto getByOrderDetailId(@PathVariable("id") Integer id) {
		OrderDetail orderDetail = orderDetailService.getById(id);
		return modelMapper.map(orderDetail, OrderDetailDto.class);
	}
}
