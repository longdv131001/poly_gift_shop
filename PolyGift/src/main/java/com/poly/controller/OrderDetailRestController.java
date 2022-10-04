package com.poly.controller;

import com.poly.request.OrderDetailRequest;
import com.poly.response.OrderDetailResponse;
import com.poly.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/order-details")
@RequiredArgsConstructor
public class OrderDetailRestController {

    private final OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<List<OrderDetailResponse>> getAllOrderDetail() {
        return ResponseEntity.ok(orderDetailService.getAllOrderDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailResponse> getByOrderDetailId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(orderDetailService.getById(id));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<List<OrderDetailResponse>> getByOrderId(@PathVariable("orderId") Integer id) {
        return ResponseEntity.ok(orderDetailService.getByOrderId(id));
    }

    @PostMapping
    public ResponseEntity<OrderDetailResponse> createOrderDetail(@RequestBody OrderDetailRequest request) {
        return ResponseEntity.ok(orderDetailService.createOrderDetail(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailResponse> updateOrderDetail(@PathVariable int id, @RequestBody OrderDetailRequest request) {
        return ResponseEntity.ok(orderDetailService.updateOrderDetail(id, request));
    }

    @DeleteMapping("{id}")
    public void deleteOrderDetail(@PathVariable("id") Integer id) {
        orderDetailService.delete(id);
    }

}
