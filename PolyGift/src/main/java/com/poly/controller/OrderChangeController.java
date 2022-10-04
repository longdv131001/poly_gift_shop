package com.poly.controller;

import com.poly.request.OrderChangeRequest;
import com.poly.response.OrderChangeResponse;
import com.poly.service.OrderChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/order-change")
@RequiredArgsConstructor
public class OrderChangeController {
    private final OrderChangeService orderChangeService;

    @GetMapping
    public ResponseEntity<List<OrderChangeResponse>> getAllOderChange() {
        return ResponseEntity.ok(orderChangeService.getAllOrderChange());
    }

    @PostMapping
    public ResponseEntity<OrderChangeResponse> createOrderChange(@RequestBody OrderChangeRequest request) {
        return ResponseEntity.ok(orderChangeService.createOrderChange(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderChangeResponse> updateOrderChange(@PathVariable("id") Integer id, @RequestBody OrderChangeRequest request) {
        return ResponseEntity.ok(orderChangeService.updateOrderChange(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderChangeResponse>> getOrderChangeByOrderId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(orderChangeService.getOrderChangeByOrderId(id));
    }

    @DeleteMapping("/{id}")
    public void deleteOrderChange(@PathVariable("id") Integer id) {
        orderChangeService.deleteOrderChange(id);
    }
}
