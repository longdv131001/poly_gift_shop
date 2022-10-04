package com.poly.controller;

import com.poly.request.ProductRequest;
import com.poly.response.ProductResponse;
import com.poly.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
    @GetMapping("/list")
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/list/user")
    public ResponseEntity<List<ProductResponse>> getAllProductAvailable() {
        return ResponseEntity.ok(productService.findAllProductAvailable());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> getOne(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
    @PostMapping()
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.create(request));
    }


    @PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable int id, @RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.update(id, request));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> disableProduct(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productService.disableProduct(id));

    }
}
