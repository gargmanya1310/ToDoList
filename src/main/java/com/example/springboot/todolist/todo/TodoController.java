package com.example.springboot.todolist.todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Controller
public class TodoController
{
    public TodoController(Todoservice todoService) {
        this.todoService = todoService;
    }

    private Todoservice todoService;
    @RequestMapping("list-todos")
    public String lisAllTodos(ModelMap model)
    {
        List<Todo> todos=todoService.findByUsername("Manya");
        model.addAttribute("todos" , todos);
        return "listTodos";
    }

}
