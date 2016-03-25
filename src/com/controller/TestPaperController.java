package com.controller;

import com.models.TestPaper;
import com.service.TestPaperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TestPaperController {
    private TestPaperService testPaperService;

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
        return "test.jsp";
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
        int num = paper.getTotalQuestion();
        int score = 100 / num;
        paper.setScore(score);
        testPaperService.updatePaper(paper);
        return "test.jsp";
    }

    @RequestMapping("/findPaper")
    public String findPapers(@RequestParam(value = "paperName") String paperName,
                            HttpServletRequest request){
        List<TestPaper> list = testPaperService.findPapers(paperName);
        request.setAttribute("papers",list);
        return "test.jsp";
    }
}