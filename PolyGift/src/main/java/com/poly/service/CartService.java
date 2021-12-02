package com.poly.service;

import java.util.List;

import com.poly.entity.Cart;

public interface CartService {
	public List<Cart> getAll();
	public Cart findById(Integer id);
	public Cart createCart(Cart cart);
	public Cart updateCart(Cart cart);
	public void deleteCart(Integer id);
	public void deleteAllCart();
}
