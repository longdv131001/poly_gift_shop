package com.poly.service;

import com.poly.entity.OrderChange;

import java.util.List;

public interface OrderChangeService {
    List<OrderChange> getAllOrderChange();

    OrderChange createOrderChange(OrderChange orderChange);

    OrderChange updateOrderChange(OrderChange orderChange);

    void deleteOrderChange(Integer id);
}
