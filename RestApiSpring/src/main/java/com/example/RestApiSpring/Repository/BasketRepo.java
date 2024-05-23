package com.example.RestApiSpring.Repository;

import com.example.RestApiSpring.Entity.BasketEntity;
import com.example.RestApiSpring.Entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepo extends CrudRepository<BasketEntity, Long> {
    public BasketEntity findByUserId(Long user_id);


}
