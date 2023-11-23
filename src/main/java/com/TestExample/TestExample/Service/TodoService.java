package com.TestExample.TestExample.Service;

import com.TestExample.TestExample.entities.Todo;
import com.TestExample.TestExample.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    // Constructor Injection or Autowiring TodoRepository

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }
    public Todo findByTitle(String title) {
        return todoRepository.findByTitle(title);
    }
}

