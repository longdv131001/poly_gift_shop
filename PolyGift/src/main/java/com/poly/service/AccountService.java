package com.poly.service;

import java.util.List;

import com.poly.entity.Account;

public interface AccountService {
	Account findByUsername(String username);
	
	Account findById(String username);

	List<Account> findAll();

	List<Account> findAll(String sortDirection, String sortBy, int pageIndex, int pageSize);

	boolean delete(String id);

	Account create(Account account);

	Account update(Account account);

	List<Account> getAdministrators();
}
