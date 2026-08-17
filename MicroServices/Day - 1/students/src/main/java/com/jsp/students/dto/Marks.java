package com.jsp.students.dto;

import lombok.Data;

@Data
public class Marks {
    private int studentId;
    private int java;
    private int sql;    
    private int web;

    
    public Marks(int studentId, int java, int sql, int web) {
        this.studentId = studentId;
        this.java = java;
        this.sql = sql;
        this.web = web;
    }

    
}
