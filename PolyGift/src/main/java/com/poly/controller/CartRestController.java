package com.poly.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.poly.dto.ProductDto;
import com.poly.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public List<CartDTO> getAllByUsername (){
		return cartService.getCartByUsername().stream().map(c -> modelMapper.map(c, CartDTO.class)).collect(Collectors.toList());
	}
	
	@PostMapping
	public CartDTO addToCart(@RequestBody CartDTO cartDTO) {
		Cart cart = modelMapper.map(cartDTO, Cart.class);
		return modelMapper.map(cartService.createCart(cart),CartDTO.class );
	}
	
	@PutMapping()
	public CartDTO updateToCart(@RequestBody CartDTO cartDTO) {
		Cart cart = modelMapper.map(cartDTO, Cart.class);
		return modelMapper.map(cartService.updateCart(cart), CartDTO.class);
	}
	
	@DeleteMapping("username")
	public void deleteCart() {
		cartService.deleteCartByUsername();
	}

	@DeleteMapping("id/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		cartService.deleteCartById(id);
	}

	@GetMapping("product")
	public CartDTO getByProductId(@RequestParam("id") Integer id){
		Cart cart = cartService.findByProductId(id);
		return modelMapper.map(cart, CartDTO.class);
	}
}
