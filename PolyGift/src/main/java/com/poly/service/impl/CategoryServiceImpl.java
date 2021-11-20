package com.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.Category;
import com.poly.repository.CategoryDAO;
import com.poly.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO cdao;
	
	
	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}

	@Override
	public Category create(Category cate) {
		return cdao.save(cate);
	}

	@Override
	public Category update(Category category) {
		Optional<Category> cate = cdao.findById(category.getId());
		if(cate.isPresent()) {
			category.setId(cate.get().getId());;
			return cdao.save(category);
		}
		return null;
		
	}

	@Override
	public Category findById(Integer id) {
		return cdao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		cdao.deleteById(id);
		
	}

}
