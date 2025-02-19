package com.example.springboot.todolist.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class Todoservice
{
    private static List<Todo> todos= new ArrayList<>();
    private static int todosCount=0;
    static
    {
        todos.add(new Todo(++todosCount,"Manya" , "Learn Spring", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"Tanuja" , "Learn Kafka", LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todosCount,"Aakanksha" , "Learn Spark", LocalDate.now().plusYears(3),false));
    }

    public List<Todo> findByUsername(String username)
    {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done )
    {
        Todo todo =  new Todo(++todosCount, username,description,targetDate,done);
        todos.add(todo);

    }
}
