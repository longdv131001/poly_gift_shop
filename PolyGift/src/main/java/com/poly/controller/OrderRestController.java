package com.poly.controller;

import com.poly.request.OrderRequest;
import com.poly.response.OrderResponse;
import com.poly.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
@RequiredArgsConstructor
public class OrderRestController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrder() {
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @PostMapping()
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        return ResponseEntity.ok(orderService.create(request));
    }

    @PutMapping()
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable("id") Integer id, @RequestBody OrderRequest request) {
        return ResponseEntity.ok(orderService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOne(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<List<OrderResponse>> findBySdt(@PathVariable("phoneNumber") String phoneNumber) {
        return ResponseEntity.ok(orderService.findByPhoneNumber(phoneNumber));
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable("id") Integer id) {
        orderService.delete(id);
    }
}
