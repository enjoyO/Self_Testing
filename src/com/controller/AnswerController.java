package com.controller;

import com.service.AnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnswerController {
    private AnswerService answerService;

    public AnswerService getAnswerService() {
        return answerService;
    }

    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        return "test.jsp";
    }
}
