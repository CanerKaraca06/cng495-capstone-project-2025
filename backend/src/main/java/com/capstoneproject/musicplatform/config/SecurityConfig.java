package com.capstoneproject.musicplatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;   //Config class
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;     //Password
import org.springframework.security.web.SecurityFilterChain;             //Hashing

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {      //Filters which http requests will be granted
        http
                .csrf(csrf -> csrf.disable())       //Cross site request forgery
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/**").permitAll() //Anyone can register
                        .requestMatchers("/api/artists/**").permitAll()
                        .requestMatchers("/api/health").permitAll()
                        .anyRequest().authenticated()         //Rest needs to be authenticated
                )
                .formLogin(form -> form.disable())   //Form login disabled
                .httpBasic(basic -> basic.disable());   //Basic auth disabled
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
