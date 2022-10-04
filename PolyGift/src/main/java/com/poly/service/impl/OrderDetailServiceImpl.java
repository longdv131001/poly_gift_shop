package com.poly.service.impl;

import com.poly.config.exception.AppException;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.entity.Product;
import com.poly.repository.OrderDetailRepository;
import com.poly.repository.OrderRepository;
import com.poly.repository.ProductRepository;
import com.poly.request.OrderDetailRequest;
import com.poly.response.OrderDetailResponse;
import com.poly.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    private final ProductRepository productRepository;

    private final OrderRepository orderRepository;

    private final ModelMapper mapper;

    @Override
    public List<OrderDetailResponse> getAllOrderDetails() {
        return orderDetailRepository.findAll()
                .stream()
                .map(orderDetail -> mapper.map(orderDetail, OrderDetailResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDetailResponse getById(Integer id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new AppException("OrderDetail not found"));
        return mapper.map(orderDetail, OrderDetailResponse.class);
    }

    @Override
    public OrderDetailResponse createOrderDetail(OrderDetailRequest request) {
        Order order = orderRepository.findById(request.getOrderId()).orElseThrow(() -> new AppException("Order not found", 404));
        Product product = productRepository.findById(request.getProductId()).orElseThrow(() -> new AppException("Product not found", 404));
        OrderDetail orderDetail = orderDetailRepository.save(OrderDetail.builder()
                .order(order)
                .product(product)
                .quantity(request.getQuantity())
                .build());
        return mapper.map(orderDetail, OrderDetailResponse.class);
    }

    @Override
    public OrderDetailResponse updateOrderDetail(int id, OrderDetailRequest request) {
        OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow(() -> new AppException("OrderDetail not found", 404));
        Order order = orderRepository.findById(request.getOrderId()).orElseThrow(() -> new AppException("Order not found", 404));
        Product product = productRepository.findById(request.getProductId()).orElseThrow(() -> new AppException("Product not found", 404));
        if (order.getOrderStatus() == 4) {
            product.setQuantity(product.getQuantity() + request.getQuantity());
            productRepository.save(product);
        }
        orderDetail.setOrder(order);
        orderDetail.setProduct(product);
        orderDetailRepository.save(orderDetail);
        return mapper.map(orderDetail, OrderDetailResponse.class);
    }

    @Override
    public void delete(Integer id) {
        orderDetailRepository.deleteById(id);

    }

    @Override
    public List<OrderDetailResponse> getByOrderId(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new AppException("Order not found", 404));
        return orderDetailRepository.findByOrder(order).stream().map(orderDetail -> mapper.map(orderDetail, OrderDetailResponse.class)).collect(Collectors.toList());
    }

}
