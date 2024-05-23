package com.example.RestApiSpring.Repository;

import com.example.RestApiSpring.Entity.OrderEntity;
import com.example.RestApiSpring.Entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<OrderEntity, Long> {
}
