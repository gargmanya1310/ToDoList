package com.example.springboot.todolist.todo;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
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
        String username= getLoggedInUsername(model);
        List<Todo> todos=todoService.findByUsername(username);
        model.addAttribute("todos" , todos);
        return "listTodos";
    }



    @RequestMapping(value="add-todo", method= RequestMethod.GET)
        public String showNewTodoPage(ModelMap model)
        {
            String username=getLoggedInUsername(model);
            Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);      //this is one side binding : from the controller
            model.put("todo",todo);
            return "todo";
        }

        @RequestMapping(value="add-todo", method= RequestMethod.POST)
            public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result)
            {
                if(result.hasErrors())
                {
                    return "todo";
                }
                String username=getLoggedInUsername(model);
                todoService.addTodo(username,todo.getDescription(), LocalDate.now().plusYears(1),false); //2 way binding in post: from bean to form from form to bean
                return "redirect:list-todos";
            }

    @RequestMapping("delete-todo")
    public String deleteTodo( @RequestParam int id)
    {
        //to delete to do with id
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="update-todo", method=RequestMethod.GET)
    public String showUpdateTodoPage( @RequestParam int id,ModelMap model)
    {
        Todo todo=todoService.findById(id);
        model.addAttribute("todo",todo);
        return "todo";
    }

    @RequestMapping(value="update-todo", method= RequestMethod.POST)
    public String updateTodoPage(ModelMap model, @Valid Todo todo, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "todo";
        }
        String username=getLoggedInUsername(model);     //changed---recheck
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private static String getLoggedInUsername(ModelMap model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();    }
}
