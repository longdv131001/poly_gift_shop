package com.poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.poly.Utils.ObjectMapperUtils;
import com.poly.dto.AccountDto;
import com.poly.entity.Account;
import com.poly.repository.AccountDAO;
import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDAO accountRepo;
	@Autowired
	private ObjectMapperUtils objectMapper;

	public static List<Account> listAccount = new ArrayList<Account>();

	@Override
	public Account findById(String username) {
		return accountRepo.findById(username).get();
	}

	public List<Account> findAll() {
		return listAccount;
	}

	public boolean checkLogin(Account account) {
		for (Account accountList : listAccount) {
			if (StringUtils.pathEquals(account.getUsername(), accountList.getUsername())
					&& StringUtils.pathEquals(account.getPassword(), accountList.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<AccountDto> findAll(String sortDirection, String sortBy, int pageIndex, int pageSize) {
		
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
	public AccountDto create(AccountDto cDto) {
		Account account = objectMapper.convertEntityAndDto(cDto, Account.class);
		accountRepo.save(account);
		cDto.setUsername(account.getUsername());
		return cDto;
	}

	@Override
	public AccountDto update(AccountDto cDto) {
		Account account = objectMapper.convertEntityAndDto(cDto, Account.class);
		account.setUsername(accountRepo.findById(account.getUsername()).get().getUsername());
		accountRepo.save(account);
		return cDto;
	}

	@Override
	public List<Account> getAdministrators() {
		// TODO Auto-generated method stub
		return accountRepo.getAdministrators();
	}

	@Override
	public List<Account> getAdminstrators() {
		// TODO Auto-generated method stub
		return null;
	}

}
