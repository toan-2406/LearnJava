package com.TestExample.TestExample.Controller;

import com.TestExample.TestExample.entities.Todo;
import com.TestExample.TestExample.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos") // Base path
public class TodoController {
    @Autowired
    private TodoService todoService;

    // Constructor Injection or Autowiring TodoService

    @GetMapping("/getAll")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTodo.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdTodo);
    }

    @GetMapping("/get")
    public  ResponseEntity<Todo> findByTitle(@RequestParam(value = "title") String title){
        return ResponseEntity.ok(todoService.findByTitle(title));
    }


}
