package com.poly.rest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dto.AuthorityDto;
import com.poly.entity.Authority;
import com.poly.service.AuthorityService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthoritiesRestController {
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<AuthorityDto> findAll(@RequestParam("admin") Optional<Boolean> admin) {
		if (admin.orElse(false)) {
			return authorityService.findAuthoritiesOfAdminstrators().stream().map(au -> modelMapper.map(au, AuthorityDto.class)).collect(Collectors.toList());
		}
		return authorityService.findAll().stream().map(au -> modelMapper.map(au, AuthorityDto.class)).collect(Collectors.toList());
	}

	@PostMapping
	public AuthorityDto save(@RequestBody AuthorityDto authorityDto) {
		Authority auth = modelMapper.map(authorityDto, Authority.class);
		return modelMapper.map(authorityService.create(auth),AuthorityDto.class );
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		authorityService.delete(id);
	}
}
