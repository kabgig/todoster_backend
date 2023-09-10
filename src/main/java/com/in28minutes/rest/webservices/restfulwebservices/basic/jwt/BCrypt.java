package com.in28minutes.rest.webservices.restfulwebservices.basic.jwt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCrypt {
    public static PasswordEncoder get() {
        return new BCryptPasswordEncoder();
    }
}
