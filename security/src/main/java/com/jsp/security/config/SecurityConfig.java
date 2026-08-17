package com.jsp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/admin").hasRole("ADMIN")
            .requestMatchers("/user").hasRole("USER")
            .requestMatchers("/wel")
            .permitAll()
        );
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }


    public UserDetailsService detailsService(){
        UserDetails admin = User
        .withUsername("densilraja")
        .password("{noop}Densil@123")
        .roles("ADMIN")
        .build();

        UserDetails user = User
        .withUsername("densilraja")
        .password("{noop}Densil@321")
        .roles("USER")
        .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
