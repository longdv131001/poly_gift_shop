package com.poly.controller;

import com.poly.request.CartRequest;
import com.poly.response.CartResponse;
import com.poly.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/cart")
@RequiredArgsConstructor
public class CartRestController {

    private final CartService cartService;

    @GetMapping
    public ResponseEntity<List<CartResponse>> getAllByUsername() {
        return ResponseEntity.ok(cartService.getCartByUsername());
    }

    @PostMapping
    public ResponseEntity<CartResponse> addToCart(@RequestBody CartRequest request) {
        return ResponseEntity.ok(cartService.createCart(request));
    }

    @PutMapping()
    public ResponseEntity<CartResponse> updateToCart(@PathVariable Integer id, @RequestBody CartRequest request) {
        return ResponseEntity.ok(cartService.updateCart(id, request));
    }

    @DeleteMapping()
    public void deleteCart() {
        cartService.deleteCartByUsername();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        cartService.deleteCartById(id);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<CartResponse> getByProductId(@PathVariable("productId") Integer productId) {
        return ResponseEntity.ok(cartService.findByProductId(productId));
    }
}
