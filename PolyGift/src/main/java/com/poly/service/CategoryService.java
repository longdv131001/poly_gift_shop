package com.poly.service;

import java.util.List;

import com.poly.entity.Category;

public interface CategoryService{

	List<Category> findAll();
	Category create (Category cate);
	Category update (Category cate);
	Category findById(Integer id);
	void delete(Integer id);
}
