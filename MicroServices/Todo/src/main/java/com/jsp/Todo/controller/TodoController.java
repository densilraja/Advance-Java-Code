package com.jsp.Todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Todo.dto.Todo;
import com.jsp.Todo.service.TodoService;

@RestController
public class TodoController {
    
    @Autowired
    private TodoService service;

    @GetMapping("/todo")
    public Todo getTodo() {
        return service.getTodo();
    }
}
