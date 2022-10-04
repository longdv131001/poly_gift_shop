package com.poly.controller;

import com.poly.request.CategoryRequest;
import com.poly.request.CategoryResponse;
import com.poly.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
@RequiredArgsConstructor
public class CategoryRestController {
    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }


    @PostMapping
    public ResponseEntity<CategoryResponse> createCate(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoryService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCate(@PathVariable Integer id, @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoryService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findByCategoryId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        categoryService.delete(id);
    }

}
