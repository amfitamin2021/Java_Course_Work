package com.example.RestApiSpring.Сontroller;


import com.example.RestApiSpring.Entity.BasketEntity;
import com.example.RestApiSpring.Service.BasketService;
import com.example.RestApiSpring.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;
    @Autowired
    private BasketService basketService;


    @PostMapping("/{user_id}")
    public ResponseEntity addOrder(@PathVariable Long user_id){
        try {
            BasketEntity b = orderService.addOrder(user_id);
            if (b != null){
                return ResponseEntity.ok(b);
            }
            else{
                return ResponseEntity.badRequest().body("Нехватает товара на складе.");
            }
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибочка");
        }
    }
}
