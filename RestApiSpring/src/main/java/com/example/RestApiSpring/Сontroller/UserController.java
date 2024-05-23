package com.example.RestApiSpring.Сontroller;


import com.example.RestApiSpring.Entity.UserEntity;
import com.example.RestApiSpring.Exception.UserAlreadyExistException;
import com.example.RestApiSpring.Exception.UserNotFoundException;
import com.example.RestApiSpring.Repository.UserRepo;
import com.example.RestApiSpring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin()
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public  ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @GetMapping("")
    public ResponseEntity getAllUser(){
        try {
            return ResponseEntity.ok(userService.getAll());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity getOneUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deleteOne(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }


}
