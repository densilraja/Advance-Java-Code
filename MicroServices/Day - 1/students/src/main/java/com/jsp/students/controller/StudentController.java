package com.jsp.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.students.dto.Marks;
import com.jsp.students.dto.Student;
import com.jsp.students.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        Marks marks = studentService.getMarksByStudentId();

        return new Student(studentId, "John Doe", marks);
    }

}
