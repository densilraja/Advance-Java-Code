package com.jsp.Todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jsp.Todo.dto.Todo;

@Service
public class TodoService {

    @Autowired
    private RestTemplate restTemplate;

    String url = "https://jsonplaceholder.typicode.com/todos/2";

    public Todo getTodo() {
        Todo todo = restTemplate.getForObject(url, Todo.class);
        return todo;
    }

}
