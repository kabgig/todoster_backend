package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
                .map(this::mapToTodoDTO)
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

    private TodoDTO mapToTodoDTO(Todo todo) {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setId(todo.getId());
        todoDTO.setDescription(todo.getDescription());
        todoDTO.setTargetDate(todo.getTargetDate());
        todoDTO.setDone(todo.isDone());
        return todoDTO;
    }

    private Todo mapToTodoEntity(TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setDescription(todoDTO.getDescription());
        todo.setTargetDate(todoDTO.getTargetDate());
        todo.setDone(todoDTO.isDone());
        return todo;
    }
}

