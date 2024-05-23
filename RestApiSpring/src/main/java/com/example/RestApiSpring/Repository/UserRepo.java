package com.example.RestApiSpring.Repository;

import com.example.RestApiSpring.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long>{
    UserEntity findByUsername(String username);
}
