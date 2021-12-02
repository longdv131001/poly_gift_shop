package com.poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.Account;
import com.poly.repository.AccountDAO;
import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDAO accountRepo;

	public static List<Account> listAccount = new ArrayList<Account>();

	@Override
	public Account findByUsername(String username) {
		return accountRepo.findByUsername(username);
	}

	public List<Account> findAll() {
		return accountRepo.findAll();
	}


	@Override
	public List<Account> findAll(String sortDirection, String sortBy, int pageIndex, int pageSize) {
		
		return null;
	}

	
	@Override
	public boolean delete(String id) {
		Account account = accountRepo.getById(id);
		if (account != null) {
			accountRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Account create(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public Account update(Account account) {
		
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
