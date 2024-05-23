package com.example.RestApiSpring.Repository;

import com.example.RestApiSpring.Entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<CategoryEntity, Long> {

}
