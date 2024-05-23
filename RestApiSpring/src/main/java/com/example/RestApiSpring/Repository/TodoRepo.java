package com.example.RestApiSpring.Repository;

import com.example.RestApiSpring.Entity.BasketEntity;
import com.example.RestApiSpring.Entity.TodoEntity;
import com.example.RestApiSpring.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
    public Iterable<TodoEntity> findByUserId(Long UserId);


    public Iterable<TodoEntity> findByUserIdAndProductId(Long UserId, Long ProductId);
}
