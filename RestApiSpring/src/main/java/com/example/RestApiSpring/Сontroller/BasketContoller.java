package com.example.RestApiSpring.Сontroller;


import com.example.RestApiSpring.Entity.BasketEntity;
import com.example.RestApiSpring.Entity.TodoEntity;
import com.example.RestApiSpring.Service.BasketService;
import com.example.RestApiSpring.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin()

@RestController
@RequestMapping("/basket")
public class BasketContoller {

    @Autowired
    private BasketService basketService;

    @GetMapping("")
    public ResponseEntity getAllBasket() {
        try {
            return ResponseEntity.ok(basketService.getAllBasket());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }
    @GetMapping("/{user_id}")
    public ResponseEntity getOneByUserId(@PathVariable Long user_id) {
        try {
            return ResponseEntity.ok(basketService.getOneByUserid(user_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }

    @PostMapping("/{user_id}")
    public ResponseEntity createBasket(@RequestBody BasketEntity basket, @PathVariable Long user_id){
        try {
            return ResponseEntity.ok(basketService.createBasket(basket,user_id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибочка");
        }
    }
    @PostMapping("/{user_id}/{product_id}/{quantity}")
    public ResponseEntity addProductInBasket(@PathVariable Long user_id, @PathVariable Long product_id, @PathVariable Long quantity){
        try {

            return ResponseEntity.ok(basketService.addProductInBasket(user_id,product_id, quantity));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }
    @DeleteMapping("/{user_id}/{product_id}")
    public ResponseEntity deleteProductInBasket(@PathVariable Long user_id, @PathVariable Long product_id){
        try {

            return ResponseEntity.ok(basketService.deleteProductInBasket(user_id,product_id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/all/{user_id}/{product_id}")
    public ResponseEntity deleteAllProductInBasket(@PathVariable Long user_id, @PathVariable Long product_id){
        try {

            return ResponseEntity.ok(basketService.deleteAllProductInBasket(user_id,product_id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }



}
