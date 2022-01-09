package com.poly.service;

import java.util.List;

import com.poly.entity.Cart;

public interface CartService {
	Cart createCart(Cart cart);
	Cart updateCart(Cart cart);
	List<Cart> getCartByUsername();
	void deleteCartByUsername();
	Cart findById(Integer id);

	void deleteCartById(Integer id);

	Cart findByProductId(Integer idProduct);
}
