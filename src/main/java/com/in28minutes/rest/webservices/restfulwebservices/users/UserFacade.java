package com.in28minutes.rest.webservices.restfulwebservices.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.in28minutes.rest.webservices.restfulwebservices.utils.Mappers.mapUserDTOtoUser;
import static com.in28minutes.rest.webservices.restfulwebservices.utils.Mappers.mapUserToUserDTO;

@Service
public class UserFacade {
    private final UserService userService;

    @Autowired
    public UserFacade(UserService userService) {
        this.userService = userService;
    }

    public void createUser(UserDTO userDTO) {
        User user = mapUserDTOtoUser(userDTO);
        userService.saveUser(user);
    }

    public UserDTO getUserByUsername(String username) {
        User user = userService.findUserByUsername(username);
        return mapUserToUserDTO(user);
    }
}
