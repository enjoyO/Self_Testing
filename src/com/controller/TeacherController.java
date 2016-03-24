package com.controller;

import com.service.TeacherService;
import org.springframework.stereotype.Controller;

@Controller
public class TeacherController {
    private TeacherService teacherService;

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
}
