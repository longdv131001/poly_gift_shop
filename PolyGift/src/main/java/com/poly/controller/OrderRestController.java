package com.poly.controller;

import com.poly.dto.OrderDto;
import com.poly.dto.ProductDto;
import com.poly.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.entity.Order;
import com.poly.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	@Autowired
	OrderService orderService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<OrderDto> getAllOrder(){
		return orderService.getAllOrder().stream().map(o -> modelMapper.map(o,OrderDto.class)).collect(Collectors.toList());
	}

	@PostMapping()
	public OrderDto createOrder(@RequestBody OrderDto orderDto) {
		Order order = modelMapper.map(orderDto,Order.class);
		return modelMapper.map(orderService.create(order),OrderDto.class);
	}

	@PutMapping()
	public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
		Order order =  modelMapper.map(orderDto,Order.class);
		return modelMapper.map(orderService.update(order),OrderDto.class);
	}

	@GetMapping("{id}")
	public OrderDto getOne(@PathVariable("id") Integer id) {
		Order order = orderService.findById(id);
		return modelMapper.map(order, OrderDto.class);
	}

	@GetMapping("sdt/{sdt}")
	public List<OrderDto>  findBySdt(@PathVariable("sdt") String sdt) {
		return orderService.findBySdt(sdt).stream().map(o -> modelMapper.map(o,OrderDto.class)).collect(Collectors.toList());
	}

	@DeleteMapping("{id}")
	public void deleteOrder(@PathVariable("id") Integer id){
		orderService.delete(id);
	}
}
