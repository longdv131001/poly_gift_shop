package com.poly.service;

import com.poly.request.AccountRequest;
import com.poly.response.AccountResponse;

import java.util.List;

public interface AccountService {
    AccountResponse findByUsername(String username);

    AccountResponse findById(String username);

    List<AccountResponse> findAll();

    AccountResponse disableUser(String username);

    AccountResponse create(AccountRequest request);

    AccountResponse update(String username, AccountRequest request);
}
