package com.in28minutes.rest.webservices.restfulwebservices.utils;

import com.in28minutes.rest.webservices.restfulwebservices.todo.Todo;
import com.in28minutes.rest.webservices.restfulwebservices.todo.TodoDTO;
import com.in28minutes.rest.webservices.restfulwebservices.users.User;
import com.in28minutes.rest.webservices.restfulwebservices.users.UserDTO;

public class Mappers {
    public static UserDTO mapUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEnabled(user.isEnabled());
        return userDTO;
    }

    public static User mapUserDTOtoUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEnabled(userDTO.isEnabled());
        return user;
    }

    public static TodoDTO mapToTodoDTO(Todo todo) {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setId(todo.getId());
        todoDTO.setDescription(todo.getDescription());
        todoDTO.setTargetDate(todo.getTargetDate());
        todoDTO.setDone(todo.isDone());
        return todoDTO;
    }

    public static Todo mapToTodoEntity(TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setDescription(todoDTO.getDescription());
        todo.setTargetDate(todoDTO.getTargetDate());
        todo.setDone(todoDTO.isDone());
        return todo;
    }
}
