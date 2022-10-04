package com.poly.service;

import com.poly.request.CartRequest;
import com.poly.response.CartResponse;

import java.util.List;

public interface CartService {
	CartResponse createCart(CartRequest request);

	CartResponse updateCart(int id, CartRequest request);

	List<CartResponse> getCartByUsername();

	void deleteCartByUsername();

	CartResponse findById(Integer id);

	void deleteCartById(Integer id);

	CartResponse findByProductId(Integer idProduct);
}
