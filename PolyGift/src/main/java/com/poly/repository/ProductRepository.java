package com.poly.repository;

import com.poly.entity.Category;
import com.poly.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByCategory(Category category);

	@Query("SELECT p FROM Product p WHERE p.available = 1 AND p.quantity > 0 ")
	List<Product> findAllProductAvailable();

	@Query("SELECT p FROM Product p WHERE p.available = 1 or p.available = 0 ")
	List<Product> findAllProduct();
}
