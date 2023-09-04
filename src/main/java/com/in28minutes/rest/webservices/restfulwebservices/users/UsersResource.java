package com.in28minutes.rest.webservices.restfulwebservices.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersResource {
    private final UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsersResource(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("createuser/")
    public void createUser(@RequestBody User user){
        String plainPassword = user.getPassword();
        String hashedPassword = passwordEncoder.encode(plainPassword); // Hash the password
        user.setPassword(hashedPassword);
        userService.saveUser(user);
        System.out.println(user + " is saved to DB");
    }
    @GetMapping("user/{username}")
    public User getUser(@PathVariable String username){
        User user = userService.findUserByUsername(username);
        System.out.println(user);
        return user;
    }
}
