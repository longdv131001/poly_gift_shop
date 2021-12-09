package com.poly.service;

import java.util.List;

import com.poly.entity.Cart;

public interface CartService {
	public Cart createCart(Cart cart);
	public Cart updateCart(Cart cart);
	List<Cart> getCartByUsername();
	void deleteCartByUsername(String username);
	Cart findById(Integer id);

	void deleteCartById(Integer id);

	Cart findByProductId(Integer idProduct);
}
