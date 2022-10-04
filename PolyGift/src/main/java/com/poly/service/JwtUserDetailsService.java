package com.poly.service;

import com.poly.entity.Account;
import com.poly.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class JwtUserDetailsService implements UserDetailsService {


	@Autowired
	private AccountRepository accountRepository;

		
		@Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    	try {
				Account a = accountRepository.findAccountByUsername(username);
				String password = a.getPassword();
				String[] roles = a.getAuthorities().stream()
						.map(e -> e.getRole().getName())
						.collect(Collectors.toList()).toArray(new String [0]);
				return User.withUsername(username).password(password).roles(roles).build();
			} catch (NoSuchElementException e) {
				throw new UsernameNotFoundException(username + "not found");
				
			}
	      
	    }
		
}
