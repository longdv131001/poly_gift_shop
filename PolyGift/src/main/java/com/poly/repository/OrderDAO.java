package com.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.entity.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer>{
	@Query("SELECT o FROM Order o WHERE o.account.username=?1")
	List<Order> findByUsername(String username);

	@Query("SELECT o FROM Order o WHERE o.sdt=?1")
	List<Order> findBySdt(String sdt);
}
