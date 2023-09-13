package com.in28minutes.rest.webservices.restfulwebservices.users;

public interface UserServiceInterface {
    User findUserByUsername(String username);
    User saveUser(User user);
}

