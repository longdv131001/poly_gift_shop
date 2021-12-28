package com.poly.service;

import java.util.List;

import com.poly.entity.Product;

public interface ProductService {

	List<Product> findAll();

	List<Product> findAllProductAvailable();

	Product findById(Integer id);

	List<Product> findByCategoryID(String string);

	Product create(Product product);

	Product update(Product product);

	Product disableProduct(Integer id);




}
