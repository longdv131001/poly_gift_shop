package com.poly.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dto.CartDTO;
import com.poly.entity.Cart;
import com.poly.service.CartService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/cart")
public class CartRestController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<CartDTO> getAll (){
		return cartService.getAll().stream().map(c -> modelMapper.map(c, CartDTO.class)).collect(Collectors.toList());
	}
	
	@PostMapping
	public CartDTO addToCart(@RequestBody CartDTO cartDTO) {
		Cart cart = modelMapper.map(cartDTO, Cart.class);
		return modelMapper.map(cartService.createCart(cart),CartDTO.class );
	}
	
	@PutMapping("{id}")
	public CartDTO updateToCart(@PathVariable("id") Integer id,@RequestBody CartDTO cartDTO) {
		Cart cart = cartService.findById(id);
		modelMapper.map(cartDTO, Cart.class);
		return modelMapper.map(cartService.updateCart(cart), CartDTO.class);
	}
	
	@DeleteMapping("{id}")
	public void deleteCart(@PathVariable("id") Integer id) {
		cartService.deleteCart(id);
	}
	

	
	
}
