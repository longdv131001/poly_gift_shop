package com.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Cart;
import org.springframework.transaction.annotation.Transactional;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	@Query(value = "select c from Cart c where c.account.username =  :username")
	List<Cart> findByUsername(@Param("username") String username);

	@Transactional
	@Modifying
	@Query(value = "DELETE  FROM Cart c WHERE c.account.username= :username")
	void deleteByUsername(@Param("username")String username);

	@Query(value = "SELECT  * FROM Cart WHERE product_id = :productId  AND username = :username", nativeQuery = true)
	Cart findByProductId(@Param("productId") Integer productId, @Param("username") String username);
}
