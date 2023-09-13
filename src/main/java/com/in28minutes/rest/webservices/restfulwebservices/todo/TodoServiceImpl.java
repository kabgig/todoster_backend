package com.in28minutes.rest.webservices.restfulwebservices.todo;

import com.in28minutes.rest.webservices.restfulwebservices.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoServiceInterface {

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodosByUsername(String username) {
        return todoRepository.findByUsername(username);
    }

    public Todo getTodoById(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    public void deleteTodoById(int id) {
        todoRepository.deleteById(id);
    }

    public Todo updateTodo(Todo updatedTodo) {
        return todoRepository.save(updatedTodo);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
