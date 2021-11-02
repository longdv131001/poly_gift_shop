package com.poly.service;

import java.util.List;

import com.poly.dto.ProductDto;
import com.poly.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryID(String string);

	Product create(ProductDto productDto);

	Product update(ProductDto productDto);

	void delete(Integer id);




}
