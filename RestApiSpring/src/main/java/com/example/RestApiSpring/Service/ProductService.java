package com.example.RestApiSpring.Service;


import com.example.RestApiSpring.Entity.CategoryEntity;
import com.example.RestApiSpring.Entity.ProductEntity;
import com.example.RestApiSpring.Entity.TodoEntity;
import com.example.RestApiSpring.Entity.UserEntity;
import com.example.RestApiSpring.Exception.UserNotFoundException;
import com.example.RestApiSpring.Repository.CategoryRepo;
import com.example.RestApiSpring.Repository.ProductRepo;
import com.example.RestApiSpring.Repository.TodoRepo;
import com.example.RestApiSpring.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ProductRepo productRepo;

    public ProductEntity createProduct(ProductEntity product){
        return productRepo.save(product);

    }

    public Iterable<ProductEntity> getAllProduct() {
        Iterable<ProductEntity> product = productRepo.findAll();
        return product;
    }

    public Iterable<ProductEntity> getAllProductPrice() {
        Iterable<ProductEntity> product = productRepo.findByOrderByPrice();
        return product;
    }

    public Iterable<ProductEntity> getAllProductByTitle() {
        Iterable<ProductEntity> product = productRepo.findByOrderByTitle();
        return product;
    }

    public Iterable<ProductEntity> getAllProductPriceDesc() {
        Iterable<ProductEntity> product = productRepo.findByOrderByPriceDesc();
        return product;
    }


    public ProductEntity getOneProduct(Long id){
        ProductEntity product = productRepo.findById(id).get();
        if(product == null){
            new Exception("Пользователь не был найден");
        }
        return product;
    }

    public ProductEntity completedProduct(ProductEntity product, Long id){
        ProductEntity new_product = productRepo.findById(id).get();
        new_product.setPrice(product.getPrice());
        new_product.setTitle(product.getTitle());
        new_product.setCategory(product.getCategory());
        return productRepo.save(new_product);
    }

    public ProductEntity updateQuantity(Long product_id, Long quantity){
        ProductEntity new_product = productRepo.findById(product_id).get();
        new_product.setQuantity(quantity);
        return productRepo.save(new_product);
    }

    public Long deleteOne(Long id) {
        productRepo.deleteById(id);
        return id;
    }


}
