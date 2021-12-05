package com.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	@Query(value = "select c from Cart c where c.account.username =  :username")
	List<Cart> findByUsername(@Param("username") String username);
	
	@Query(value = "DELETE  FROM Cart c WHERE c.account.username= :username")
	Cart deleteByUsername(@Param("username")String username);
}
