package com.example.springboot.todolist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration
{
//  InMemoryUserDetailsManager
//  InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager()
    {

        UserDetails user1 = createNewUser("Manya Garg", "1234");
        UserDetails user2 = createNewUser("Java", "12345");

        return new InMemoryUserDetailsManager(user1, user2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails user=User.builder()
                                .passwordEncoder(passwordEncoder)
                                .username(username)
                                .password(password)
                                .roles("USER","ADMIN")
                                .build();
        return user;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //All URLs are protected
    //A login form is shown for unauthorized requests
    //CSRF disable
    //Frames

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());

        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frameOptionsConfig-> frameOptionsConfig.disable()));

        return http.build();
    }


}
