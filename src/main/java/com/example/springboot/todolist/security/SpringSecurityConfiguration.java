package com.example.springboot.todolist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration
{
//  InMemoryUserDetailsManager
//  InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(PasswordEncoder passwordEncoder)
    {
        Function<String, String> encoder = input -> passwordEncoder().encode(input);

        UserDetails user=User.builder()
                                .passwordEncoder(encoder)
                                .username("Manya Garg")
                                .password("1234")
                                .roles("USER","ADMIN")
                                .build();
        return new InMemoryUserDetailsManager(user);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
