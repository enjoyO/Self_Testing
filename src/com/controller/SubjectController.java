package com.controller;

import com.service.SubjectService;
import org.springframework.stereotype.Controller;

@Controller
public class SubjectController {
    private SubjectService subjectService;

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
}
