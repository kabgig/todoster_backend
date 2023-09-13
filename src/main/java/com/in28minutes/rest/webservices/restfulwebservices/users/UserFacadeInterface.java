package com.in28minutes.rest.webservices.restfulwebservices.users;

public interface UserFacadeInterface {
    void createUser(UserDTO userDTO);
    UserDTO getUserByUsername(String username);
}

