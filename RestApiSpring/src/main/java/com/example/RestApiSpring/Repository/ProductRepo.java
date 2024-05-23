package com.example.RestApiSpring.Repository;

import com.example.RestApiSpring.Entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepo extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findByQuantityGreaterThan(int quantity);


    List<ProductEntity> findByOrderByPrice();
    List<ProductEntity> findByOrderByPriceDesc();
    List<ProductEntity> findByOrderByTitle();

}
