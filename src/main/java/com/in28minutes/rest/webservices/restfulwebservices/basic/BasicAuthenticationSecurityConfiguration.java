package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthenticationSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()); //all urls are protected
        // http.formLogin(Customizer.withDefaults()); // a login for is shown to all unauth. requests
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(
                session -> session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS));
        http.csrf(csrf -> csrf.disable()); //CSRF is disabled
        //http.headers(header -> header.frameOptions(frameOptions -> frameOptions.disable()));// iFrame is allowed
        return http.build();
    }
}
