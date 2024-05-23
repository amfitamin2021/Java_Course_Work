package com.example.RestApiSpring.Service;

import com.example.RestApiSpring.Entity.ProductEntity;
import com.example.RestApiSpring.Entity.TodoEntity;
import com.example.RestApiSpring.Entity.UserEntity;
import com.example.RestApiSpring.Repository.ProductRepo;
import com.example.RestApiSpring.Repository.TodoRepo;
import com.example.RestApiSpring.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    public TodoEntity createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return todoRepo.save(todo);
    }

    public  Iterable<TodoEntity> GetAllTodosByUser(Long userId){

        Iterable<TodoEntity> todo = todoRepo.findByUserId(userId);


        return todo;
    }

//    public TodoEntity GetTodoById(Long TodoId){
//
//    }

    public Iterable<TodoEntity> isAdded(Long id, Long product_id){
//        TodoEntity todo = todoRepo.findById(id).get();
//        ProductEntity product = productRepo.findById(product_id).get();
//        todo.setIsAdded(!todo.getIsAdded());

        Iterable<TodoEntity> todos = todoRepo.findByUserIdAndProductId(id, product_id);

        for (TodoEntity t : todos){
            t.setIsAdded(!t.getIsAdded());
            todoRepo.save(t);
        }

        return todos;
    }

    public Iterable<TodoEntity> getAll() {
        Iterable<TodoEntity> todo = todoRepo.findAll();
        return todo;
    }

}
