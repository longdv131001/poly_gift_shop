package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.Utils.ObjectMapperUtils;
import com.poly.dto.CategoryDto;
import com.poly.entity.Category;
import com.poly.repository.CategoryDAO;
import com.poly.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO cdao;
	
	@Autowired
	private ObjectMapperUtils objectMapper;
	
	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}

	@Override
	public Category create(CategoryDto cate) {
		Category category = objectMapper.convertEntityAndDto(cate, Category.class);
		return cdao.save(category);
	}

	@Override
	public Category update(CategoryDto cate) {
		Category category = objectMapper.convertEntityAndDto(cate, Category.class);
		return cdao.save(category);
		
	}


	@Override
	public Category findById(Integer id) {
		return cdao.findById(id).get();
	}

}
