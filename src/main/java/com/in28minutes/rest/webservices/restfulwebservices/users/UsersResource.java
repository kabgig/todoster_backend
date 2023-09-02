package com.in28minutes.rest.webservices.restfulwebservices.users;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersResource {

    @PostMapping("create/{username}/{password}")
    public void createUser(
            @PathVariable String username,
            @PathVariable String password){
        System.out.println("user created with name: " + username + " and pass: " + password);
        //return ResponseEntity.noContent().build();
    }
}
