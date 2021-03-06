package com.poly.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dto.AccountDto;
import com.poly.entity.Account;
import com.poly.service.AccountService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountService accountService;
	
	@Autowired
	ModelMapper modelMapper;

	@PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
	@GetMapping 
	public List<AccountDto> getAllAccounts(){
		return accountService.findAll().stream().map(a -> modelMapper.map(a, AccountDto.class)).collect(Collectors.toList());
	}
	
	@GetMapping("/{username}")
	public AccountDto findUserByUsername(@PathVariable String username) {
		Account a = accountService.findByUsername(username);
		return modelMapper.map(a, AccountDto.class);
			
		
	}

	@PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
	@PostMapping()
	public AccountDto create(@RequestBody AccountDto accountDTO) {
		Account account = modelMapper.map(accountDTO, Account.class);
		return modelMapper.map(accountService.create(account),AccountDto.class );
	}

	@PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
	@PutMapping("{id}")
	public AccountDto update(@PathVariable("id") String username, @RequestBody AccountDto accountDTO) {
		Account account = modelMapper.map(accountDTO, Account.class);
		return modelMapper.map(accountService.update(account),AccountDto.class );
	}

	@PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
	@DeleteMapping("{id}")
	public AccountDto disableUser(@PathVariable("id") String id) {
		Account account = accountService.disableUser(id);
		return  modelMapper.map(account,AccountDto.class);
	}

}
