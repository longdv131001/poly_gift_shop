package com.poly.service;

import com.poly.request.OrderDetailRequest;
import com.poly.response.OrderDetailResponse;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailResponse> getAllOrderDetails();

    OrderDetailResponse getById(Integer id);

    OrderDetailResponse createOrderDetail(OrderDetailRequest request);

    OrderDetailResponse updateOrderDetail(int id, OrderDetailRequest request);

    void delete(Integer id);

    List<OrderDetailResponse> getByOrderId(Integer id);
}
