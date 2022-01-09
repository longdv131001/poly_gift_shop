package com.poly.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("{id}")
	public OrderDetailDto getByOrderDetailId(@PathVariable("id") Integer id) {
		OrderDetail orderDetail = orderDetailService.getById(id);
		return modelMapper.map(orderDetail, OrderDetailDto.class);
	}

	@GetMapping("order-id/{id}")
	public List<OrderDetailDto> getByOrderId(@PathVariable("id") Integer id) {
		return orderDetailService.getByOrderId(id).stream().map(o -> modelMapper.map(o, OrderDetailDto.class)).collect(Collectors.toList());
	}

	@PostMapping
	public OrderDetailDto createOrderDetail(@RequestBody OrderDetailDto orderDetailDto){
		OrderDetail orderDetail = modelMapper.map(orderDetailDto,OrderDetail.class);
		return modelMapper.map(orderDetailService.createOrderDetail(orderDetail),OrderDetailDto.class);
	}

	@PutMapping()
	public OrderDetailDto updateOrderDetail(@RequestBody OrderDetailDto orderDetailDto){
		OrderDetail orderDetail = modelMapper.map(orderDetailDto,OrderDetail.class);
		return modelMapper.map(orderDetailService.updateOrderDetail(orderDetail),OrderDetailDto.class);
	}

	@DeleteMapping("{id}")
	public void deleteOrderDetail(@PathVariable("id") Integer id){
		orderDetailService.delete(id);
	}

}
