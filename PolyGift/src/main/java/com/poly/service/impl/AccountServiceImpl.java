package com.poly.service.impl;

import com.poly.config.exception.AppException;
import com.poly.entity.Account;
import com.poly.repository.AccountRepository;
import com.poly.request.AccountRequest;
import com.poly.response.AccountResponse;
import com.poly.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public AccountResponse findByUsername(String username) {
        Account account = accountRepository.findById(username)
                .orElseThrow(() -> new AppException("Account not found", 404));
        return mapper.map(account, AccountResponse.class);
    }

    public List<AccountResponse> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(account -> mapper.map(account, AccountResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponse disableUser(String username) {
        Account account = accountRepository.findById(username)
                .orElseThrow(() -> new AppException("Account not found", 404));
        account.setDisable(true);
        accountRepository.save(account);
        return mapper.map(account, AccountResponse.class);
    }

    @Override
    public AccountResponse create(AccountRequest request) {
        Account account = accountRepository.save(Account.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName())
                .email(request.getEmail())
                .isDisable(false)
                .build());
        return mapper.map(account, AccountResponse.class);
    }

    @Override
    public AccountResponse update(String username, AccountRequest request) {
        Account account = accountRepository.findById(username)
                .orElseThrow(() -> new AppException("Account not found", 404));
        account.setUsername(request.getUsername());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setFullName(request.getFullName());
        account.setEmail(request.getEmail());
        account.setDisable(request.isDisable());
        accountRepository.save(account);
        return mapper.map(account, AccountResponse.class);
    }

    @Override
    public AccountResponse findById(String username) {
        Account account = accountRepository.findById(username)
                .orElseThrow(() -> new AppException("Account not found", 404));
        return mapper.map(account, AccountResponse.class);
    }


}
