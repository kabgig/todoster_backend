package com.in28minutes.rest.webservices.restfulwebservices.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersResource {
    private final UserService userService;

    @Autowired
    public UsersResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("createuser/")
    public void createUser(@RequestBody User user){
        userService.saveUser(user);
        System.out.println(user + " is saved to DB");
    }

//    public void registerUser(String username, String rawPassword) {
//        //  String encodedPassword = passwordEncoder.encode(rawPassword);
//
//        User user = new User();
//        user.setUsername(username);
//        // user.setPassword(encodedPassword);
//        user.setEnabled(true); // Enable the user, or set it based on your requirements
//
//        userRepository.save(user);
//    }
}
