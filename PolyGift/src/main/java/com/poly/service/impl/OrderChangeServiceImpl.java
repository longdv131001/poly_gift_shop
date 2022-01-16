package com.poly.service.impl;

import com.poly.entity.Order;
import com.poly.entity.OrderChange;
import com.poly.repository.AccountDAO;
import com.poly.repository.OrderChangeRepository;
import com.poly.repository.OrderDAO;
import com.poly.service.OrderChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderChangeServiceImpl implements OrderChangeService {

    @Autowired
    private OrderChangeRepository orderChangeRepository;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public List<OrderChange> getAllOrderChange() {
        return orderChangeRepository.findAll();
    }

    @Override
    public OrderChange createOrderChange(OrderChange orderChange) {
        Optional<Order> order = orderDAO.findById(orderChange.getOrder().getId());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            if(order.isPresent()){
                String username = auth.getName();
                orderChange.setAccount(accountDAO.findAccountByUsername(username));
                orderChange.setCreatedDate(LocalDateTime.now());
                orderChange.setOrder(order.get());
                return orderChangeRepository.save(orderChange);
            }
        }
        return null;
    }

    @Override
    public OrderChange updateOrderChange(OrderChange orderChange) {
        Optional<Order> order = orderDAO.findById(orderChange.getOrder().getId());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            if(order.isPresent()){
                String username = auth.getName();
                orderChange.setAccount(accountDAO.findAccountByUsername(username));
                orderChange.setOrder(order.get());
                return orderChangeRepository.save(orderChange);
            }

        }
        return null;
    }

    @Override
    public void deleteOrderChange(Integer id) {
        orderChangeRepository.deleteById(id);
    }

    @Override
    public List<OrderChange> getOrderChangeByOrderId(Integer id) {
        return orderChangeRepository.getOrderChangeByOrderId(id);
    }
}
