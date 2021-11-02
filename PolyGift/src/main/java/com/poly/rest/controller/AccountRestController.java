package com.poly.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@GetMapping({"","{username}"})
	public List<Account> findUserByUsername(@RequestParam("username") Optional<String> username) {
		if(username.isPresent()) {
			return accountService.findByUsername(username);
		}
		else 
			return accountService.findAll();
		
	}
	
	@PostMapping()
	public AccountDto create(@RequestBody AccountDto accountDTO) {
		return accountService.create(accountDTO);
	}
	
	@PutMapping("{id}")
	public AccountDto update(@PathVariable("id") String id,@RequestBody AccountDto accountDTO) {
		return accountService.update( accountDTO);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		accountService.delete(id);
	}

}
