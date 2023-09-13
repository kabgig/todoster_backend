package com.in28minutes.rest.webservices.restfulwebservices.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersResource {
    private final UserFacadeInterface userFacade;

    @Autowired
    public UsersResource(UserFacadeInterface userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping("createuser/")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){
        userFacade.createUser(userDTO);
        System.out.println(userDTO.getUsername() + " is saved to DB");
        return ResponseEntity.status(HttpStatus.OK).body("User created successfully");
    }

    @GetMapping("user/{username}")
    public UserDTO getUser(@PathVariable String username) {
        UserDTO userDTO = userFacade.getUserByUsername(username);
        System.out.println(userDTO);
        return userDTO;
    }
}
