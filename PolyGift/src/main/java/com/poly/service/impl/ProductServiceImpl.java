package com.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.Utils.ObjectMapperUtils;
import com.poly.dto.ProductDto;
import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.repository.CategoryDAO;
import com.poly.repository.ProductDAO;
import com.poly.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO pdao;
	
	@Autowired
	ObjectMapperUtils modelMapper;
	
	@Autowired
	CategoryDAO cdao;

	@Override
	public List<Product> findAll() {
		return pdao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return pdao.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryID(String string) {
		return pdao.findByCategoryID(string);
	}

	@Override
	public Product create(ProductDto productDto) {
		Optional<Category> result = cdao.findById(productDto.getCategoryId());
		if(result.isPresent()) {
			Product product = modelMapper.convertEntityAndDto(productDto, Product.class);
			product.setCategory(result.get());
			return pdao.save(product);
		}
		return null;
		
	}

	@Override
	public Product update(ProductDto productDto) {
		Optional<Category> result = cdao.findById(productDto.getCategoryId());
		if(result.isPresent()) {
			Product product = modelMapper.convertEntityAndDto(productDto, Product.class);
			product.setCategory(result.get());
			return pdao.save(product);
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		 pdao.deleteById(id);
	}
}
