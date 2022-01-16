package com.poly.repository;

import com.poly.entity.OrderChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderChangeRepository extends JpaRepository<OrderChange,Integer> {
   @Query("select c from OrderChange c where c.order.id=?1 ")
    List<OrderChange> getOrderChangeByOrderId(Integer id);
}
