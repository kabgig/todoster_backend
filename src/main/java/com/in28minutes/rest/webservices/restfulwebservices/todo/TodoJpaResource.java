package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoJpaResource {
    private final TodoFacadeInterface todoFacade;

    @Autowired
    public TodoJpaResource(TodoFacadeInterface todoFacade) {
        this.todoFacade = todoFacade;
    }

    @GetMapping("users/{username}/todos")
    public List<TodoDTO> retrieveTodos(@PathVariable String username){
        return todoFacade.retrieveTodos(username);
    }

    @GetMapping("users/{username}/todos/{id}")
    public TodoDTO retrieveTodo(@PathVariable String username, @PathVariable int id){
        return todoFacade.retrieveTodo(username, id);
    }

    @DeleteMapping("users/{username}/todos/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable String username, @PathVariable int id){
        return todoFacade.deleteTodo(id);
    }

    @PutMapping("users/{username}/todos/{id}")
    public TodoDTO updateTodo(
            @PathVariable String username,
            @PathVariable int id,
            @RequestBody TodoDTO todoDTO){
        return todoFacade.updateTodo(id, todoDTO, username);
    }

    @PostMapping("users/{username}/todos")
    public TodoDTO createTodo(
            @PathVariable String username,
            @RequestBody TodoDTO todoDTO){
        return todoFacade.createTodo(username, todoDTO);
    }
}
