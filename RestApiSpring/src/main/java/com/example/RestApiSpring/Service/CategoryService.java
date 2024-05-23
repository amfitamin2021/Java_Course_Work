package com.example.RestApiSpring.Service;


import com.example.RestApiSpring.Entity.CategoryEntity;
import com.example.RestApiSpring.Entity.ProductEntity;
import com.example.RestApiSpring.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;
    public CategoryEntity createCategory(CategoryEntity category){

        return categoryRepo.save(category);

    }

    public Iterable<CategoryEntity> getAllCategory() {
        Iterable<CategoryEntity> category = categoryRepo.findAll();
        return category;
    }
}
