package com.example.springboot.todolist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration
{
//  InMemoryUserDetailsManager
//  InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager()
    {
          UserDetails user=User.withDefaultPasswordEncoder()
                .username("Manya Garg")
                .password("1234")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
