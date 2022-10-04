package com.poly.service.impl;

import com.poly.config.exception.AppException;
import com.poly.entity.Account;
import com.poly.entity.Order;
import com.poly.entity.OrderChange;
import com.poly.repository.AccountRepository;
import com.poly.repository.OrderChangeRepository;
import com.poly.repository.OrderRepository;
import com.poly.request.OrderChangeRequest;
import com.poly.response.OrderChangeResponse;
import com.poly.service.OrderChangeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderChangeServiceImpl implements OrderChangeService {

    private final OrderChangeRepository orderChangeRepository;

    private final AccountRepository accountRepository;

    private final OrderRepository orderRepository;

    private final ModelMapper mapper;

    @Override
    public List<OrderChangeResponse> getAllOrderChange() {
        return orderChangeRepository.findAll()
                .stream()
                .map(orderChange -> mapper.map(orderChange, OrderChangeResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderChangeResponse createOrderChange(OrderChangeRequest request) {
        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new AppException("Order not found", 404));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String username = auth.getName();
            Account account = accountRepository.findAccountByUsername(username);
            OrderChange orderChange = orderChangeRepository.save(OrderChange.builder()
                    .account(account)
                    .order(order)
                    .createdDate(request.getCreatedDate())
                    .status(request.getStatus())
                    .note(request.getNote())
                    .build());
            return mapper.map(orderChange, OrderChangeResponse.class);
        } else {
            throw new AppException("User not login", 401);
        }
    }

    @Override
    public OrderChangeResponse updateOrderChange(int id, OrderChangeRequest request) {
        OrderChange orderChange = orderChangeRepository.findById(id)
                .orElseThrow(() -> new AppException("OrderChange not found"));
        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new AppException("Order not found", 404));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String username = auth.getName();
            orderChange.setAccount(accountRepository.findAccountByUsername(username));
            orderChange.setOrder(order);
            return mapper.map(orderChange, OrderChangeResponse.class);
        } else {
            throw new AppException("User not login", 401);
        }
    }

    @Override
    public void deleteOrderChange(Integer id) {
        orderChangeRepository.deleteById(id);
    }

    @Override
    public List<OrderChangeResponse> getOrderChangeByOrderId(Integer id) {
        return orderChangeRepository.getOrderChangeByOrderId(id)
                .stream()
                .map(orderChange -> mapper.map(orderChange, OrderChangeResponse.class))
                .collect(Collectors.toList());
    }
}
