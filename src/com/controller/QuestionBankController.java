package com.controller;

import com.service.QuestionBankService;
import org.springframework.stereotype.Controller;

@Controller
public class QuestionBankController {
    private QuestionBankService questionBankService;

    public QuestionBankService getQuestionBankService() {
        return questionBankService;
    }

    public void setQuestionBankService(QuestionBankService questionBankService) {
        this.questionBankService = questionBankService;
    }
}
