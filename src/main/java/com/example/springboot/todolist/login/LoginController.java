package com.example.springboot.todolist.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController
{
    private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("login")
    public String gotoLoginPage(@RequestParam String name , ModelMap model)
    {
        model.put("name", name);
        logger.debug("Request Param is {}", name);
        logger.info("I want it printed at info level");
        logger.warn("I want it printed at warn level");
        System.out.println("Request Param is " + name);        //Not for production

        return "login";
    }
}
