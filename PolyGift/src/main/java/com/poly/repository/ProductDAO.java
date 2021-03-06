package com.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryID(String id);

	@Query("SELECT p FROM Product p WHERE p.Available = 1 AND p.Quantity > 0 ")
	List<Product> findAllProductAvailable();

	@Query("SELECT p FROM Product p WHERE p.Available = 1 or p.Available = 0 ")
	List<Product> findAllProduct();
}
