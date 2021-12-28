package com.poly.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dto.ProductDto;
import com.poly.entity.Product;
import com.poly.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductService productService;
	
	@Autowired
	ModelMapper modelMapper;

	@PreAuthorize("hasAnyAuthority('ROLE_Admin','ROLE_Staff')")
	@GetMapping("/list")
	public List<ProductDto> getAll() {
		return productService.findAll().stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
	}
	@GetMapping("/list/user")
	public List<ProductDto> getAllProductAvailable() {
		return productService.findAllProductAvailable().stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
	}

	@GetMapping("{id}")
	public ProductDto getOne(@PathVariable("id") Integer id) {
		Product product = productService.findById(id);
		return modelMapper.map(product, ProductDto.class);
	}

	@PostMapping()
	public ProductDto create(@RequestBody ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		return modelMapper.map(productService.create(product), ProductDto.class);
	}
	
	@PutMapping()
	public ProductDto update(@RequestBody ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		return modelMapper.map(productService.update(product), ProductDto.class);
	}
	
	@DeleteMapping("/{id}")
	public ProductDto disableProduct(@PathVariable("id") Integer id) {
		Product product = productService.disableProduct(id);
		return modelMapper.map(product,ProductDto.class);
	}
}
