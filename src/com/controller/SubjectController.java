package com.controller;

import com.models.QuestionBank;
import com.models.Subject;
import com.models.TestPaper;
import com.service.QuestionBankService;
import com.service.SubjectService;
import com.service.TestPaperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SubjectController {
    private SubjectService subjectService;
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

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping("/addSubject")
    public String addSubject(Subject subject){
        System.out.println(subject.getTeacher());
        subjectService.addSubject(subject);
        return "/getAllSubject.action";
    }

    @RequestMapping("/deleteSubject")
    public void deleteSubject(@RequestParam(value = "id") int id){
        subjectService.deleteSubject(id);
    }

    @RequestMapping("/modifySubject")
    public String modifySubject(@RequestParam(value = "id") int id,
                                 HttpServletRequest request){
        Subject subject = subjectService.modifySubject(id);
        request.setAttribute("modify",subject);
        return "/welcome.jsp";
    }

    @RequestMapping("/updateSubject")
    public String updateSubject(Subject subject){
        System.out.println(subject.getId());
        Subject subject1 = subjectService.modifySubject(subject.getId());
        subject1.setClassName(subject.getClassName());
        subject1.setTeacher(subject.getTeacher());
        subjectService.updateSubject(subject1);
        return "/getAllSubject.action";
    }

    @RequestMapping("/findSubjects")
    public String findSubjects(@RequestParam(value = "name") String name,
                               HttpServletRequest request){
        List<Subject> list = subjectService.findSubjects(name);
        request.setAttribute("allSubjects",list);
        return "right（课程）.jsp";
    }

    @RequestMapping("/getAllSubject")
    public String getAllSubject(HttpServletRequest request){
        List<Subject> list = subjectService.getAllSubjects();
        request.setAttribute("allSubjects",list);
        return "right（课程）.jsp";
    }

    @RequestMapping("/toPaperMan")
    public String toPaperMan(HttpServletRequest request){
        List<Subject> list = subjectService.getAllSubjects();
        request.setAttribute("allSubjects",list);
        List<TestPaper> list1 = testPaperService.getAllPapers();
        request.setAttribute("allPapers",list1);
        List<QuestionBank> list2 = questionBankService.getAllQuestions();
        request.setAttribute("allQuestions",list2);
        return "tab （试题管理）.jsp";
    }
}
