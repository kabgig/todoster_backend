package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//DISABLED!!!!
//@RestController
public class NotUsedTodoResource {

    private NotUsedTodoService notUsedTodoService;

    public NotUsedTodoResource(NotUsedTodoService notUsedTodoService) {
        this.notUsedTodoService = notUsedTodoService;
    }

    @GetMapping("users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username){
        return notUsedTodoService.findByUsername(username);
    }

    @GetMapping("users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username, @PathVariable int id){
        return notUsedTodoService.findById(id);
    }

    @DeleteMapping("users/{username}/todos/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable String username, @PathVariable int id){
        notUsedTodoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("users/{username}/todos/{id}")
    public Todo updateTodo(
            @PathVariable String username,
            @PathVariable int id,
            @RequestBody Todo todo){
        notUsedTodoService.updateTodo(todo);
        return todo;
    }

    @PostMapping("users/{username}/todos")
    public Todo createTodo(
            @PathVariable String username,
            @RequestBody Todo todo){
        Todo createdTodo = notUsedTodoService.addTodo(
                username,
                todo.getDescription(),
                todo.getTargetDate(),
                todo.isDone());
        return createdTodo;
    }
}
