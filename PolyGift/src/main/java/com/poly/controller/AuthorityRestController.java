package com.poly.controller;

import com.poly.request.AuthorityRequest;
import com.poly.response.AuthorityResponse;
import com.poly.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
@RequiredArgsConstructor
public class AuthorityRestController {

    private final AuthorityService authorityService;

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping
    public ResponseEntity<List<AuthorityResponse>> findAll(@RequestParam("admin") Optional<Boolean> admin) {
        if (admin.orElse(false)) {
            return ResponseEntity.ok(authorityService.findAuthoritiesOfAdminstrators());
        }
        return ResponseEntity.ok(authorityService.findAll());
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<AuthorityResponse> save(@RequestBody AuthorityRequest request) {
        return ResponseEntity.ok(authorityService.create(request));
    }

    @PreAuthorize("hasAuthority('Admin')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        authorityService.delete(id);
    }
}
