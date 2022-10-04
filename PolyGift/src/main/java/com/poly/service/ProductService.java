package com.poly.service;

import com.poly.request.ProductRequest;
import com.poly.response.ProductResponse;

import java.util.List;

public interface ProductService {

	List<ProductResponse> findAll();

	List<ProductResponse> findAllProductAvailable();

	ProductResponse findById(Integer id);

	ProductResponse create(ProductRequest request);

	ProductResponse update(int id, ProductRequest request);

	ProductResponse disableProduct(Integer id);




}
