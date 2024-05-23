package com.example.RestApiSpring.Service;


import com.example.RestApiSpring.Entity.BasketEntity;
import com.example.RestApiSpring.Entity.ProductEntity;
import com.example.RestApiSpring.Entity.UserEntity;
import com.example.RestApiSpring.Repository.BasketRepo;
import com.example.RestApiSpring.Repository.ProductRepo;
import com.example.RestApiSpring.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private BasketRepo basketRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    public BasketEntity addOrder(Long user_id){
        UserEntity user = userRepo.findById(user_id).get();
        BasketEntity user_basket = basketRepo.findById(user.getId()).get();
        if (user_basket.deleteAllProductInBasket(user_basket)){
            return basketRepo.save(user_basket);
        }
        return null;
    }
}
