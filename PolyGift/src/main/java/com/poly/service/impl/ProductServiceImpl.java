package com.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	CategoryDAO cdao;

	@Override
	public List<Product> findAll() {
		return pdao.findAll();
	}

	@Override
	public List<Product> findAllProductAvailable() {
		return pdao.findAllProductAvailable();
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
	public Product create(Product product) {
		Optional<Category> cate = cdao.findById(product.getCategory().getId());
		if(cate.isPresent()) {
			product.setCategory(cate.get());
			return pdao.save(product);
		}
		return null;
		
	}

	@Override
	public Product update(Product product) {
		Optional<Product> p = pdao.findById(product.getId());
		Optional<Category> cate = cdao.findById(product.getCategory().getId());
		if(cate.isPresent() && p.isPresent()) {
			product.setId(p.get().getId());
			product.setCategory(cate.get());
			return pdao.save(product);
		}
		return null;
	}

	@Override
	public Product disableProduct(Integer id) {
		Optional<Product> p =  pdao.findById(id);
		if (p.isPresent()){
			p.get().setAvailable(-1);
			return  pdao.save(p.get());
		}
		return null;
	}


}
