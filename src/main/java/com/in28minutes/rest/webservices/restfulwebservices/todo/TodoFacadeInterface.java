package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoFacadeInterface {
    List<TodoDTO> retrieveTodos(String username);

    TodoDTO retrieveTodo(String username, int id);

    ResponseEntity<Object> deleteTodo(int id);

    TodoDTO updateTodo(int id, TodoDTO todoDTO, String username);

    TodoDTO createTodo(String username, TodoDTO todoDTO);
}
