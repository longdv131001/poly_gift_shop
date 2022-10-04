package com.poly.service.impl;

import com.poly.config.exception.AppException;
import com.poly.entity.Account;
import com.poly.entity.Authority;
import com.poly.entity.Role;
import com.poly.repository.AccountRepository;
import com.poly.repository.AuthorityRepository;
import com.poly.repository.RoleRepository;
import com.poly.request.AuthorityRequest;
import com.poly.response.AuthorityResponse;
import com.poly.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper mapper;

    @Override
    public List<AuthorityResponse> findAll() {
        return authorityRepository.findAll()
                .stream()
                .map(authority -> mapper.map(authority, AuthorityResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorityResponse create(AuthorityRequest request) {
        Account account = accountRepository.findById(request.getUsername())
                .orElseThrow(() -> new AppException("Account not found", 404));
        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new AppException("Role not found", 404));

        Authority auth = authorityRepository.save(Authority.builder()
                .account(account)
                .role(role)
                .build());
        return mapper.map(auth, AuthorityResponse.class);
    }

    @Override
    public List<AuthorityResponse> findAuthoritiesOfAdminstrators() {
        List<Account> accounts = accountRepository.getAdministrators();
        return authorityRepository.authoritiesOf(accounts)
                .stream()
                .map(authority -> mapper.map(authority, AuthorityResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Authority authority = authorityRepository.findById(id)
                .orElseThrow(() -> new AppException("Authority not found", 404));
        authorityRepository.delete(authority);

    }

}
