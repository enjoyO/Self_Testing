package com.controller;

import com.models.Subject;
import com.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SubjectController {
    private SubjectService subjectService;

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping("/addSubject")
    public String addSubject(Subject subject){
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
        return "test.jsp";
    }

    @RequestMapping("/updateSubject")
    public String updateSubject(Subject subject){
        subjectService.updateSubject(subject);
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
        return "tab （试题管理）.jsp";
    }
}
