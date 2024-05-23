package com.example.RestApiSpring.Сontroller;


import com.example.RestApiSpring.Entity.TodoEntity;
import com.example.RestApiSpring.Service.TodoService;
import com.example.RestApiSpring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin()
@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PostMapping("/{userId}")
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @PathVariable Long userId){
        try {

            return ResponseEntity.ok(todoService.createTodo(todo,userId));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибочка");
        }
    }

    @PutMapping("/{id}/{product_id}")
    public ResponseEntity isAdded(@PathVariable Long id, @PathVariable Long product_id){
        try {
            return ResponseEntity.ok(todoService.isAdded(id, product_id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибочка");
        }
    }

    @GetMapping
    public ResponseEntity getAllTodo(){
        try {
            return ResponseEntity.ok(todoService.getAll());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }


    @GetMapping("/user/{userId}")
    public ResponseEntity getOneUser(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(todoService.GetAllTodosByUser(userId));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибочка");
        }

    }
}
