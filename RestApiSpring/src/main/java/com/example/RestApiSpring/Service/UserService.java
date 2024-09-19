package com.example.RestApiSpring.Service;

import com.example.RestApiSpring.Entity.UserEntity;
import com.example.RestApiSpring.Exception.UserAlreadyExistException;
import com.example.RestApiSpring.Exception.UserNotFoundException;
import com.example.RestApiSpring.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;



    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw  new UserAlreadyExistException("Пользователь с таким именем уже существует!");
        }
        return userRepo.save(user);
    }

    public UserEntity getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw new UserNotFoundException("Пользователь не был найден");
        }
        return user;
    }

    public Long deleteOne(Long id) {
        userRepo.deleteById(id);
        return id;
    }

    public Iterable<UserEntity> getAll() {
        Iterable<UserEntity> user = userRepo.findAll();
        return user;
    }

}
