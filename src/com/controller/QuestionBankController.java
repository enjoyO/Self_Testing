package com.controller;

import com.models.QuestionBank;
import com.models.TestPaper;
import com.service.QuestionBankService;
import com.service.TestPaperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class QuestionBankController {
    private QuestionBankService questionBankService;
    private TestPaperService testPaperService;

    public TestPaperService getTestPaperService() {
        return testPaperService;
    }

    public void setTestPaperService(TestPaperService testPaperService) {
        this.testPaperService = testPaperService;
    }

    public QuestionBankService getQuestionBankService() {
        return questionBankService;
    }

    public void setQuestionBankService(QuestionBankService questionBankService) {
        this.questionBankService = questionBankService;
    }

    @RequestMapping("/addQuestion")
    public String addQuestion(QuestionBank questionBank){
        questionBankService.addQuestion(questionBank);
        return "tab （试题管理）.jsp";
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
        return "/welcome.jsp";
    }

    @RequestMapping("/updateQuestion")
    public String updateQuestion(QuestionBank questionBank){
        questionBankService.updateQuestion(questionBank);
        return "/toPaperMan.action";
    }

    @RequestMapping("/findQuestions")
    public String findQuestions(@RequestParam(value = "content") String content,
                                HttpServletRequest request){
        List<QuestionBank> list = questionBankService.findQuestions(content);
        request.setAttribute("questions",list);
        return "/welcome.jsp";
    }

    @RequestMapping("/getAllQuestions")
    public String getAllQuestions(@RequestParam(value = "paperId") int paperId,HttpServletRequest request){
        List<QuestionBank> list = questionBankService.getAllQuestions();
        request.setAttribute("allQuestions",list);
        request.setAttribute("paperId",paperId);
        TestPaper paper = testPaperService.modifyPaper(paperId);
        request.setAttribute("pa",paper);
        return "tab （试题计组）.jsp";
    }
}
