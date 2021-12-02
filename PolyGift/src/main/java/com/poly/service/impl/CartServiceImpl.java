package com.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.Account;
import com.poly.entity.Cart;
import com.poly.entity.Product;
import com.poly.repository.AccountDAO;
import com.poly.repository.CartRepository;
import com.poly.repository.ProductDAO;
import com.poly.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private AccountDAO accRepo;
	
	@Autowired
	private ProductDAO pRepo;
	
	@Override
	public List<Cart> getAll() {
		return cartRepo.findAll();
	}

	@Override
	public Cart createCart(Cart cart) {
		Optional<Product> product = pRepo.findById(cart.getProduct().getId());
		Optional<Account> account = accRepo.findById(cart.getAccount().getUsername());
		if(product.isPresent() && account.isPresent()) {
			cart.setAccount(account.get());
			cart.setProduct(product.get());
			return cartRepo.save(cart);
		}
		return null;
	}

	@Override
	public Cart updateCart(Cart cart) {
		Optional<Product> product = pRepo.findById(cart.getProduct().getId());
		Optional<Account> account = accRepo.findById(cart.getAccount().getUsername());
		if(product.isPresent() && account.isPresent()) {
			cart.setAccount(account.get());
			cart.setProduct(product.get());
			return cartRepo.save(cart);
		}
		return null;
	}

	@Override
	public void deleteCart(Integer id) {
		cartRepo.deleteById(id);
		
	}

	@Override
	public void deleteAllCart() {
		cartRepo.deleteAll();
		
	}

	@Override
	public Cart findById(Integer id) {
		return cartRepo.findById(id).get();
	}
	
}
