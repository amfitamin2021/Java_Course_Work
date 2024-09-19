package com.example.RestApiSpring.Сontroller;


import com.example.RestApiSpring.Entity.BasketEntity;
import com.example.RestApiSpring.Entity.UserEntity;
import com.example.RestApiSpring.Service.AuthService;
import com.example.RestApiSpring.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("")
    public ResponseEntity Register(@Valid @RequestBody UserEntity user){
        try {
            return ResponseEntity.ok(authService.Register(user));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @GetMapping("")
    public ResponseEntity Login(@RequestParam String email, @RequestParam String password){
        try {
            return ResponseEntity.ok(authService.Login(email, password));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
