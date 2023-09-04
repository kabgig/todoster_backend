package com.in28minutes.rest.webservices.restfulwebservices.basic.jwt;

import com.in28minutes.rest.webservices.restfulwebservices.users.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationController {

    private final JwtTokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public JwtAuthenticationController(JwtTokenService tokenService,
                                       AuthenticationManager authenticationManager, UserService userService, PasswordEncoder passwordEncoder) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtTokenResponse> generateToken(
            @RequestBody JwtTokenRequest jwtTokenRequest) {
        String hashedPassword = userService
                .findUserByUsername(jwtTokenRequest.username())
                .getPassword();

        boolean passwordMatches = passwordEncoder.matches(
                jwtTokenRequest.password(),
                hashedPassword);

        if (!passwordMatches) {
            throw new BadCredentialsException("Invalid password");
        }
        var authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        jwtTokenRequest.username(),
                        hashedPassword);

        var authentication =
                authenticationManager.authenticate(authenticationToken);

        var token = tokenService.generateToken(authentication);

        return ResponseEntity.ok(new JwtTokenResponse(token));
    }
}
