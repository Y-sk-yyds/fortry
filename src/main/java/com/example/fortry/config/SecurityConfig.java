package com.example.fortry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()   // 所有请求都放行
                )
                .csrf(csrf -> csrf.disable());  // 关掉 CSRF 防护
        return http.build();
    }
}
