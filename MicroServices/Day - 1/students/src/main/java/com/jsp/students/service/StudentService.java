package com.jsp.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jsp.students.dto.Marks;

@Service
public class StudentService {

    @Autowired
    private RestTemplate restTemplate;

    public Marks getMarksByStudentId() {

        String url = "http://localhost:8081/marks/1";

        return restTemplate.getForObject(url, Marks.class);
    }

}