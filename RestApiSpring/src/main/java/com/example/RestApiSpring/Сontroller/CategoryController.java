package com.example.RestApiSpring.Сontroller;

import com.example.RestApiSpring.Entity.CategoryEntity;
import com.example.RestApiSpring.Entity.ProductEntity;
import com.example.RestApiSpring.Service.CategoryService;
import com.example.RestApiSpring.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin()
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity createCategory(@RequestBody CategoryEntity category) {
        try {
            categoryService.createCategory(category);
            return ResponseEntity.ok("Категория успешно добавлена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("")
    public ResponseEntity getAllCategory() {
        try {
            return ResponseEntity.ok(categoryService.getAllCategory());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }
}
