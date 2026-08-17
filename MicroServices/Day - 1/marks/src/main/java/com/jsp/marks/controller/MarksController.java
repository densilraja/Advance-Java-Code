package com.jsp.marks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.marks.dto.Marks;

@RestController
public class MarksController {
    
    @GetMapping("/marks/{id}")
    public Marks getMarksById(@PathVariable int id) {
        return new Marks(id, 85, 90, 80);
    }
}
