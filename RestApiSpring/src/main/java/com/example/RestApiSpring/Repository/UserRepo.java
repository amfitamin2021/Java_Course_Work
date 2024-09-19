package com.example.RestApiSpring.Repository;

import com.example.RestApiSpring.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long>{
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
}
