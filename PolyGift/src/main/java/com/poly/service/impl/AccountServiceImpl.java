package com.poly.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.poly.entity.Account;
import com.poly.repository.AccountDAO;
import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDAO accountRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static List<Account> listAccount = new ArrayList<Account>();

	@Override
	public Account findByUsername(String username) {
		return accountRepo.findByUsername(username);
	}

	public List<Account> findAll() {
		return accountRepo.findAll();
	}

	@Override
	public Account disableUser(String username) {
		Optional<Account> account = accountRepo.findById(username);
		if (account.isPresent()){
			account.get().setDisable(true);
			return  accountRepo.save(account.get());
		}
		return null;
	}


	@Override
	public Account create(Account account) {
		account.setUsername(account.getUsername());
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		account.setFullname(account.getFullname());
		account.setEmail(account.getEmail());
		account.setDisable(false);
		return accountRepo.save(account);
	}

	@Override
	public Account update(Account account) {
		account.setUsername(account.getUsername());
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		account.setFullname(account.getFullname());
		account.setEmail(account.getEmail());
		account.setDisable(account.isDisable());
		return accountRepo.save(account);
	}
		
	

	@Override
	public List<Account> getAdministrators() {
		return accountRepo.getAdministrators();
	}

	@Override
	public Account findById(String username) {
		return accountRepo.findById(username).get();
	}


}
