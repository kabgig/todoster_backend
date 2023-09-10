package com.in28minutes.rest.webservices.restfulwebservices.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersResource {
    private final UserFacade userFacade;

    @Autowired
    public UsersResource(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping("createuser/")
    public void createUser(@RequestBody UserDTO userDTO){
        userFacade.createUser(userDTO);
        System.out.println(userDTO.getUsername() + " is saved to DB");
    }

    @GetMapping("user/{username}")
    public UserDTO getUser(@PathVariable String username) {
        UserDTO userDTO = userFacade.getUserByUsername(username);
        System.out.println(userDTO);
        return userDTO;
    }
}
