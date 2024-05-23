package com.example.RestApiSpring.Service;

import com.example.RestApiSpring.Entity.BasketEntity;
import com.example.RestApiSpring.Entity.ProductEntity;
import com.example.RestApiSpring.Entity.TodoEntity;
import com.example.RestApiSpring.Entity.UserEntity;
import com.example.RestApiSpring.Repository.BasketRepo;
import com.example.RestApiSpring.Repository.CategoryRepo;
import com.example.RestApiSpring.Repository.ProductRepo;
import com.example.RestApiSpring.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BasketService {

    @Autowired
    private BasketRepo basketRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

    public Iterable<BasketEntity> getAllBasket() {
        Iterable<BasketEntity> basket = basketRepo.findAll();
        return basket;
    }

    public BasketEntity getOneByUserid(Long user_id) {
        BasketEntity basket = basketRepo.findById(user_id).get();
        return basket;
    }

    public BasketEntity createBasket(BasketEntity basket, Long user_id){
        UserEntity user = userRepo.findById(user_id).get();
        basket.setUser(user);
        return basketRepo.save(basket);
    }

    public BasketEntity addProductInBasket(Long user_id, Long product_id, Long quantity){
          UserEntity user = userRepo.findById(user_id).get();
          BasketEntity userbasket = basketRepo.findById(user.getId()).get();
          ProductEntity product = productRepo.findById(product_id).get();
          if (product.getQuantity() < quantity){
              return userbasket;
          }
          userbasket.addProductInBasket(product, quantity);
          return basketRepo.save(userbasket);
    }
    public BasketEntity deleteProductInBasket(Long user_id, Long product_id){
        UserEntity user = userRepo.findById(user_id).get();
        BasketEntity userbasket = basketRepo.findById(user.getId()).get();
        ProductEntity product = productRepo.findById(product_id).get();
        userbasket.deleteProductInBasket(product);
        return basketRepo.save(userbasket);
    }

    public BasketEntity deleteAllProductInBasket(Long user_id, Long product_id){
        UserEntity user = userRepo.findById(user_id).get();
        BasketEntity userbasket = basketRepo.findById(user.getId()).get();
        ProductEntity product = productRepo.findById(product_id).get();
        userbasket.deleteAllProductInBasket(product);
        return basketRepo.save(userbasket);
    }


//    public BasketEntity updateProductQuantity(Long id, int quantity) {
//        Product product = getProductById(id);
//        product.setQuantity(product.getQuantity() - quantity);
//        productRepository.save(product);
//    }



}
