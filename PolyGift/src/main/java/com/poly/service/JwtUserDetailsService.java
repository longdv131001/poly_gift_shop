package com.poly.service;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.poly.entity.Account;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private AccountService accountService;

		
		@Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    	try {
				Account a = accountService.findByUsername(username);
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
