package com.poly.controller;

import com.poly.request.AccountRequest;
import com.poly.response.AccountResponse;
import com.poly.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

    @PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAllAccounts() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<AccountResponse> findUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(accountService.findByUsername(username));


    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
    @PostMapping()
    public ResponseEntity<AccountResponse> create(@RequestBody AccountRequest request) {
        return ResponseEntity.ok(accountService.create(request));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
    @PutMapping("{id}")
    public ResponseEntity<AccountResponse> update(@PathVariable("id") String username, @RequestBody AccountRequest request) {
        return ResponseEntity.ok(accountService.update(username, request));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
    @DeleteMapping("{id}")
    public ResponseEntity<AccountResponse> disableUser(@PathVariable("id") String username) {
        return ResponseEntity.ok(accountService.disableUser(username));
    }

}
