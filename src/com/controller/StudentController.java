package com.controller;

import com.service.StudentService;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
