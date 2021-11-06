package com.poly.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dto.CategoryDto;
import com.poly.entity.Category;
import com.poly.service.CategoryService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping()
	public List<Category> getAll() {
		return categoryService.findAll();
	}
	
	@PostMapping
	public Category createCate(@RequestBody CategoryDto cate) {
		return categoryService.create(cate);
	}
	
	@PutMapping("{id}")
	public Category updateCate(@PathVariable("id") Optional<String> id,@RequestBody CategoryDto cate) {
		return categoryService.update(cate);
		
	}
	
	@GetMapping("{id}")
	public Category findByCategoryId (@PathVariable("id") Integer id) {
		return categoryService.findById(id);
	}
}
