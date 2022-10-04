package com.poly.repository;

import com.poly.entity.Account;
import com.poly.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByAccount(Account account);

    List<Order> findByPhoneNumber(String phoneNumber);
}
