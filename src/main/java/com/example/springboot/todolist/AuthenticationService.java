package com.example.springboot.todolist;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService
{
    public boolean authenticate(String username, String password)
    {
        boolean inValidUserName= username.equalsIgnoreCase("Manya Garg");
        boolean inValidPassword= password.equalsIgnoreCase("1234");
        return inValidUserName && inValidPassword;
        //return false;
    }
}
