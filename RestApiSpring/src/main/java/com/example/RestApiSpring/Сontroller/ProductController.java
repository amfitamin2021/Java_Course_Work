package com.example.RestApiSpring.Сontroller;

import com.example.RestApiSpring.Entity.ProductEntity;
import com.example.RestApiSpring.Entity.UserEntity;
import com.example.RestApiSpring.Service.ProductService;
import com.example.RestApiSpring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductEntity product) {
        try {
            productService.createProduct(product);
            return ResponseEntity.ok("Продукт успешно добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/{product_id}/{quantity}")
    public ResponseEntity updateQuantity(@PathVariable Long product_id, @PathVariable Long quantity) {
        try {
            productService.updateQuantity(product_id, quantity);
            return ResponseEntity.ok("Country Успешно изменен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }



    @GetMapping("")
    public ResponseEntity getAllProduct() {
        try {
            return ResponseEntity.ok(productService.getAllProduct());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }


    @GetMapping("/price")
    public ResponseEntity getAllProductPrice() {
        try {
            return ResponseEntity.ok(productService.getAllProductPrice());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }

    @GetMapping("/price_desc")
    public ResponseEntity getAllProductPriceDesc() {
        try {
            return ResponseEntity.ok(productService.getAllProductPriceDesc());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }

    @GetMapping("/name")
    public ResponseEntity getAllProductTitle() {
        try {
            return ResponseEntity.ok(productService.getAllProductByTitle());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity getOneProduct(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.getOneProduct(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Нет такого продукта");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.deleteOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity completeProduct(@RequestBody ProductEntity product,@PathVariable Long id){
        System.out.println(product);
        System.out.println(id);
        try {
            return ResponseEntity.ok(productService.completedProduct(product, id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибочка");
        }
    }


}
