package com.poly.service;

import java.util.Arrays;
import java.util.List;

import com.poly.entity.OrderDetail;

public interface OrderDetailService {
      public List<OrderDetail> getAllOrderDetails();
      public OrderDetail getById(Integer id);
      public OrderDetail createOrderDetail(OrderDetail orderDetail);
      public OrderDetail updateOrderDetail(OrderDetail orderDetail);
      public void delete(Integer id);

      List<OrderDetail>  getByOrderId(Integer id);
}
