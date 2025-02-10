package com.example.springboot.todolist.todo;

import java.time.LocalDate;
import java.util.List;

public class Todoservice
{
    private static List<Todo> todos;
    static
    {
        todos.add(new Todo(1,"Manya" , "Learn Spring", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(2,"Tanuja" , "Learn Kafka", LocalDate.now().plusYears(2),false));
        todos.add(new Todo(3,"Aakanksha" , "Learn Spark", LocalDate.now().plusYears(3),false));
    }

    public List<Todo> findByUsername(String username)
    {
        return todos;
    }
}
