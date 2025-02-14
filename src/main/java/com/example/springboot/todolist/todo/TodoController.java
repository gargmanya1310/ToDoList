package com.example.springboot.todolist.todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Controller
@SessionAttributes("name")
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
@RequestMapping(value="add-todo", method= RequestMethod.GET)
    public String showNewTodoPage( )
    {
        return "todo";
    }

@RequestMapping(value="add-todo", method= RequestMethod.POST)
    public String addNewTodoPage( )
    {

        return "redirect:list-todos";
    }



}
