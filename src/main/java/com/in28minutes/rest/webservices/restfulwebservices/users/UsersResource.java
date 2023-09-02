package com.in28minutes.rest.webservices.restfulwebservices.users;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersResource {

    @PostMapping("createuser/")
    public void createUser(@RequestBody User user){
        System.out.println(user);
        //return ResponseEntity.noContent().build();
    }
}
