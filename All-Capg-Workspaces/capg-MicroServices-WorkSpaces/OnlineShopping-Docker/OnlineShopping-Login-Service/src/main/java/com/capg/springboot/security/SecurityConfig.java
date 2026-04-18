package com.capg.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// @Configuration tells Spring - "this class contains configuration beans"
// Run this class when application starts
@Configuration
// @EnableWebSecurity activates Spring Security for this application
@EnableWebSecurity
public class SecurityConfig {

    // @Bean tells Spring - "store the return value of this method
    // in Spring container so it can be @Autowired anywhere"
    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder automatically:
        // 1. Adds a random SALT to each password before hashing
        //    (so same password gives different hash each time)
        // 2. Runs the hash 2^10 = 1024 times (strength=10)
        //    (makes brute force attacks very slow)
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF - not needed for REST APIs
            // CSRF protection is for browser form submissions
            // Our Postman/React clients don't need it
            .csrf(csrf -> csrf.disable())

            // Configure which endpoints need authentication
            .authorizeHttpRequests(auth -> auth
                // These endpoints are PUBLIC — no token needed
                // Anyone can register or login
                .requestMatchers("/login/addUser").permitAll()
                .requestMatchers("/login/validateUser").permitAll()
             // Public - called by other microservices (FeignClient)
                .requestMatchers("/login/getUserByUserId/**").permitAll()
                .requestMatchers("/login/getUserByEmail/**").permitAll()

                // Public - signout and delete during testing
                // Once JWT filter is added, these will be protected
                .requestMatchers("/login/signOut/**").permitAll()
                .requestMatchers("/login/removeUser/**").permitAll()

                .anyRequest().authenticated()
            )

            // STATELESS - don't create HTTP sessions
            // Each request must carry its own JWT token
            // This is the REST API standard - no session cookies
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

        return http.build();
    }
}