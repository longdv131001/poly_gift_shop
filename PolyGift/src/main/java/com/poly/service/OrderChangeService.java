package com.poly.service;

import com.poly.request.OrderChangeRequest;
import com.poly.response.OrderChangeResponse;

import java.util.List;

public interface OrderChangeService {
    List<OrderChangeResponse> getAllOrderChange();

    OrderChangeResponse createOrderChange(OrderChangeRequest request);

    OrderChangeResponse updateOrderChange(int id, OrderChangeRequest request);

    void deleteOrderChange(Integer id);

    List<OrderChangeResponse> getOrderChangeByOrderId(Integer id);
}
