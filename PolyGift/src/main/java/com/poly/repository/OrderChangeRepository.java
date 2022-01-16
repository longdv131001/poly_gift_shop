package com.poly.repository;

import com.poly.entity.OrderChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderChangeRepository extends JpaRepository<OrderChange,Integer> {
}
