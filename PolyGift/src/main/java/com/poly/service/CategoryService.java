package com.poly.service;

import java.util.List;

import com.poly.dto.CategoryDto;
import com.poly.entity.Category;

public interface CategoryService{

	List<Category> findAll();
	Category create (CategoryDto cate);
	Category update (CategoryDto cate);
	Category findById(Integer id);

}
