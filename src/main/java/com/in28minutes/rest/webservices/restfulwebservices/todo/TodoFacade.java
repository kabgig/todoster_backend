package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.in28minutes.rest.webservices.restfulwebservices.utils.Mappers.mapToTodoDTO;
import static com.in28minutes.rest.webservices.restfulwebservices.utils.Mappers.mapToTodoEntity;

@Service
public class TodoFacade {
    private final TodoService todoService;

    @Autowired
    public TodoFacade(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<TodoDTO> retrieveTodos(String username) {
        List<Todo> todos = todoService.getTodosByUsername(username);
        return todos.stream()
                .map(todo -> mapToTodoDTO(todo))
                .collect(Collectors.toList());
    }

    public TodoDTO retrieveTodo(String username, int id) {
        Todo todo = todoService.getTodoById(id);
        return mapToTodoDTO(todo);
    }

    public ResponseEntity<Object> deleteTodo(int id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }

    public TodoDTO updateTodo(int id, TodoDTO todoDTO, String username) {
        Todo updatedTodo = mapToTodoEntity(todoDTO);
        updatedTodo.setId(id);
        updatedTodo.setUsername(username);
        Todo savedTodo = todoService.updateTodo(updatedTodo);
        return mapToTodoDTO(savedTodo);
    }

    public TodoDTO createTodo(String username, TodoDTO todoDTO) {
        Todo todo = mapToTodoEntity(todoDTO);
        todo.setUsername(username);
        Todo savedTodo = todoService.createTodo(todo);
        return mapToTodoDTO(savedTodo);
    }
}

