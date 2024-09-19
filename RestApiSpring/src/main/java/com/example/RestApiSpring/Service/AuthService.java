package com.example.RestApiSpring.Service;

import com.example.RestApiSpring.Entity.UserEntity;
import com.example.RestApiSpring.Repository.UserRepo;
import com.example.RestApiSpring.Utils.Sha512PasswordEncoder;
import io.jsonwebtoken.Claims;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.Token;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthService {

    private class TokenResponse{
        public String token;
    }
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtService jwtService;

    private Sha512PasswordEncoder passwordEncoder = new Sha512PasswordEncoder();

    public UserEntity Register(UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity res = userRepo.save(user);
        return res;
    };

    public TokenResponse Login(String email, String password){

        UserEntity dbUser = userRepo.findByEmail(email);
        if (!passwordEncoder.matches(password, dbUser.getPassword())){
            return null;
        }

        String token = jwtService.generateToken(dbUser);

        TokenResponse res = new TokenResponse();
        res.token = token;

        return res;
    }
}
