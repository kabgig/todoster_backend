package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.List;

public interface TodoServiceInterface {
    List<Todo> getTodosByUsername(String username);

    Todo getTodoById(int id);

    void deleteTodoById(int id);

    Todo updateTodo(Todo updatedTodo);

    Todo createTodo(Todo todo);
}
