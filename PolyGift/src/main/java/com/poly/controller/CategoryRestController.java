package com.poly.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping()
	public List<CategoryDto> getAll() {
		return categoryService.findAll().stream().map(c -> modelMapper.map(c, CategoryDto.class)).collect(Collectors.toList());
	}
	
	@PostMapping
	public CategoryDto createCate(@RequestBody CategoryDto cateDto) {
		Category category = modelMapper.map(cateDto, Category.class);
		return modelMapper.map(categoryService.create(category), CategoryDto.class);
	}
	
	@PutMapping()
	public CategoryDto updateCate(@RequestBody CategoryDto cateDto) {
		Category category = modelMapper.map(cateDto, Category.class);
		return modelMapper.map(categoryService.update(category), CategoryDto.class);
		
	}
	
	@GetMapping("{id}")
	public CategoryDto findByCategoryId (@PathVariable("id") Integer id) {
		Category category =  categoryService.findById(id);
		return modelMapper.map(category, CategoryDto.class);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		categoryService.delete(id);
	}
	
}
