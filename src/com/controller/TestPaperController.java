package com.controller;

import com.models.QuestionBank;
import com.models.TestPaper;
import com.service.QuestionBankService;
import com.service.TestPaperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestPaperController {
    private TestPaperService testPaperService;
    private QuestionBankService questionBankService;

    public QuestionBankService getQuestionBankService() {
        return questionBankService;
    }

    public void setQuestionBankService(QuestionBankService questionBankService) {
        this.questionBankService = questionBankService;
    }

    public TestPaperService getTestPaperService() {
        return testPaperService;
    }

    public void setTestPaperService(TestPaperService testPaperService) {
        this.testPaperService = testPaperService;
    }

    @RequestMapping("/addPaper")
    public String addPaper(TestPaper paper) {
        int num = paper.getTotalQuestion();
        int score = 100 / num;
        paper.setScore(score);
        testPaperService.addPaper(paper);
        return "/getAllPapers.action";
    }

    @RequestMapping("/deletePaper")
    public void deletePaper(@RequestParam(value = "id") int id) {
        testPaperService.deletePaper(id);
    }

    @RequestMapping("/modifyPaper")
    public String modifyPaper(@RequestParam(value = "id") int id,
                              HttpServletRequest request) {
        TestPaper paper = testPaperService.modifyPaper(id);
        request.setAttribute("modify", paper);
        return "test.jsp";
    }

    @RequestMapping("/updatePaper")
    public String updatePaper(TestPaper paper) {
        TestPaper p = testPaperService.modifyPaper(paper.getId());
        p.setQuestionId(paper.getQuestionId());
        testPaperService.updatePaper(p);
        return "/getAllPapers.action";
    }

    @RequestMapping("/findPaper")
    public String findPapers(@RequestParam(value = "paperName") String paperName,
                            HttpServletRequest request){
        List<TestPaper> list = testPaperService.findPapers(paperName);
        request.setAttribute("allPapers",list);
        return "right（试卷管理）.jsp";
    }

    @RequestMapping("/getAllPapers")
    public String getAllPapers(HttpServletRequest request){
        List<TestPaper> list = testPaperService.getAllPapers();
        request.setAttribute("allPapers",list);
        return "right（试卷管理）.jsp";
    }

    @RequestMapping("/toMainStu")
    public String toMainStu(HttpServletRequest request){
        List<TestPaper> list = testPaperService.getAllPapers();
        request.setAttribute("allPapers",list);
        return "imglist1 （进入自测）.jsp";
    }

    @RequestMapping("/getPaper")
    public String getPaper(HttpServletRequest request){
        int id = 1;
        TestPaper paper = testPaperService.modifyPaper(id);
        String questionIds = paper.getQuestionId();
        String[] questionId = questionIds.split(",");
        int[] questionIdInt = new int[questionId.length];
        for (int k = 0; k < questionId.length; k++) {
            questionIdInt[k] = Integer.parseInt(questionId[k]);
        }
        List<QuestionBank> list = new ArrayList<>();

        for(int i = 0;i<questionIdInt.length;i++){
            QuestionBank questionBank = questionBankService.modifyQuestion(questionIdInt[i]);
            list.add(questionBank);
        }
        request.setAttribute("questions",list);
        return "imglist1（答题）.jsp";
    }
}