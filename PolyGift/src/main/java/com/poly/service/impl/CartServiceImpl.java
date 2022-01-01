package com.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import com.poly.entity.Cart;
import com.poly.entity.Product;
import com.poly.repository.AccountDAO;
import com.poly.repository.CartRepository;
import com.poly.repository.ProductDAO;
import com.poly.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private AccountDAO accRepo;

	@Autowired
	private ProductDAO pRepo;

	@Override
	public List<Cart> getCartByUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String username = auth.getName();
			return cartRepository.findByUsername(username);
		}
		return null;
	}

	@Override
	public Cart createCart(Cart cart) {
		Optional<Product> product = pRepo.findById(cart.getProduct().getId());
		if (product.isPresent()) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken)) {
				String username = auth.getName();
				cart.setAccount(accRepo.findByUsername(username));
				cart.setProduct(product.get());
				return cartRepository.save(cart);
			}
		}
		return null;
	}

	@Override
	public Cart updateCart(Cart cart) {
		Optional<Product> product = pRepo.findById(cart.getProduct().getId());
		if (product.isPresent()) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken)) {
				String username = auth.getName();
				cart.setAccount(accRepo.findByUsername(username));
				cart.setProduct(product.get());
				return cartRepository.save(cart);
			}
		}
		return null;
	}

	@Override
	public void deleteCartByUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		cartRepository.deleteByUsername(username);
	}

	@Override
	public Cart findById(Integer id) {
		return cartRepository.findById(id).get();
	}

	@Override
	public void deleteCartById(Integer id) {
		 cartRepository.deleteById(id);
	}

	@Override
	public Cart findByProductId(Integer idProduct) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return cartRepository.findByProductId(idProduct, username);
	}


}
