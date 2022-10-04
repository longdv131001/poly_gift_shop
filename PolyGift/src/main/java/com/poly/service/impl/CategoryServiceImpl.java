package com.poly.service.impl;

import com.poly.config.exception.AppException;
import com.poly.entity.Category;
import com.poly.repository.CategoryRepository;
import com.poly.request.CategoryRequest;
import com.poly.request.CategoryResponse;
import com.poly.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;
    private static final String CATEGORY_NOT_FOUND = "Category not found";

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> mapper.map(category, CategoryResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse create(CategoryRequest request) {
        Category category = categoryRepository.save(Category.builder()
                .name(request.getName())
                .build());
        return mapper.map(category, CategoryResponse.class);
    }

    @Override
    public CategoryResponse update(int id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new AppException(CATEGORY_NOT_FOUND, 404));
        category.setName(request.getName());
        categoryRepository.save(category);
        return mapper.map(category, CategoryResponse.class);
    }

    @Override
    public CategoryResponse findById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new AppException(CATEGORY_NOT_FOUND, 404));
        return mapper.map(category, CategoryResponse.class);
    }

    @Override
    public void delete(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new AppException(CATEGORY_NOT_FOUND, 404));
        categoryRepository.delete(category);

    }

}
