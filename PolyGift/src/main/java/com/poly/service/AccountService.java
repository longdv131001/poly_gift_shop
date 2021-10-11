package com.poly.service;

import java.util.List;

import com.poly.dto.AccountDto;
import com.poly.entity.Account;

public interface AccountService {
	Account findById(String username);

	List<Account> findAll();

	List<Account> getAdminstrators();

	List<AccountDto> findAll(String sortDirection, String sortBy, int pageIndex, int pageSize);

	boolean delete(String id);

	AccountDto create(AccountDto cDto);

	AccountDto update(AccountDto cDto);

	List<Account> getAdministrators();
}
