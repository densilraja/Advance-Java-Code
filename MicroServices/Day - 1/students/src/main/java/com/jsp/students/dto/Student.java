package com.jsp.students.dto;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private Marks marks;

    public Student(int id, String name, Marks marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}
