package com.poly.service;

import com.poly.request.CategoryRequest;
import com.poly.request.CategoryResponse;

import java.util.List;

public interface CategoryService {

	List<CategoryResponse> findAll();

	CategoryResponse create(CategoryRequest request);

	CategoryResponse update(int id, CategoryRequest request);

	CategoryResponse findById(Integer id);

	void delete(Integer id);
}
