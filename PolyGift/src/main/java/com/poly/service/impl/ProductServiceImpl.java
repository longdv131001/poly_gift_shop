package com.poly.service.impl;

import com.poly.config.exception.AppException;
import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.repository.CategoryRepository;
import com.poly.repository.ProductRepository;
import com.poly.request.ProductRequest;
import com.poly.response.ProductResponse;
import com.poly.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final ModelMapper mapper;

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAllProduct()
                .stream()
                .map(product -> mapper.map(product, ProductResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> findAllProductAvailable() {
        return productRepository.findAllProductAvailable()
                .stream()
                .map(product -> mapper.map(product, ProductResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException("Product not found", 404));
        return mapper.map(product, ProductResponse.class);
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new AppException("Category not found", 404));
        Product product = productRepository.save(Product.builder()
                .available(request.getAvailable())
                .category(category)
                .createdDate(request.getCreatedDate())
                .image(request.getImage())
                .description(request.getDescription())
                .price(request.getPrice())
                .name(request.getName())
                .quantity(request.getQuantity())
                .build());
        return mapper.map(product, ProductResponse.class);

    }

    @Override
    public ProductResponse update(int id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException("Product not found", 404));
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new AppException("Category not found", 404));
        product.setCategory(category);
        product.setAvailable(request.getAvailable());
        product.setImage(request.getImage());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setName(request.getName());
        product.setQuantity(request.getQuantity());
        productRepository.save(product);
        return mapper.map(product, ProductResponse.class);
    }

    @Override
    public ProductResponse disableProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException("Product not found", 404));
        product.setAvailable((byte) -1);
        return mapper.map(product, ProductResponse.class);
    }


}
