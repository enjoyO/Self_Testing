package com.controller;

import com.models.QuestionBank;
import com.service.QuestionBankService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class QuestionBankController {
    private QuestionBankService questionBankService;

    public QuestionBankService getQuestionBankService() {
        return questionBankService;
    }

    public void setQuestionBankService(QuestionBankService questionBankService) {
        this.questionBankService = questionBankService;
    }

    @RequestMapping("/addQuestion")
    public String addQuestion(QuestionBank questionBank){
        questionBankService.addQuestion(questionBank);
        return "test.jsp";
    }

    @RequestMapping("/deleteQuestion")
    public void deleteQuestion(@RequestParam(value = "id") int id){
        questionBankService.deleteQuestion(id);
    }

    @RequestMapping("/modifyQuestion")
    public String modifyQuestion(@RequestParam(value = "id") int id,
                                 HttpServletRequest request){
        QuestionBank questionBank = questionBankService.modifyQuestion(id);
        request.setAttribute("question",questionBank);
        return "test.jsp";
    }

    @RequestMapping("/updateQuestion")
    public String updateQuestion(QuestionBank questionBank){
        questionBankService.updateQuestion(questionBank);
        return "test.jsp";
    }

    @RequestMapping("/findQuestions")
    public String findQuestions(@RequestParam(value = "content") String content,
                                HttpServletRequest request){
        List<QuestionBank> list = questionBankService.findQuestions(content);
        request.setAttribute("questions",list);
        return "test.jsp";
    }
}
