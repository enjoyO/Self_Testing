package com.controller;

import com.models.Student;
import com.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/login")
    public void login(@RequestParam(value = "id") int id,
                      @RequestParam(value = "password") String password,
                      HttpServletResponse response,
                      HttpSession session) throws Exception{
        Student student = studentService.login(id,password);
        if(student==null){
            response.getWriter().print("wrong");
        }else{
            session.setAttribute("student",student);
        }
    }

    @RequestMapping("/addStudent")
    public String addStudent(Student student){
        studentService.addStudent(student);
        return "test.jsp";
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam(value = "id") int id){
        studentService.deleteStudent(id);
        return "test.jsp";
    }

    @RequestMapping("/modifyStudent")
    public String modifyStudent(@RequestParam(value = "id") int id,
                                HttpServletRequest request){
        Student student = studentService.modify(id);
        request.setAttribute("modify",student);
        return "test.jsp";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(Student student){
        studentService.update(student);
        return "test.jsp";
    }

    @RequestMapping("/findByName")
    public String findByName(@RequestParam(value = "name") String name,
                             HttpServletRequest request){
        List<Student> list = studentService.findByName(name);
        request.setAttribute("students",list);
        return "test.jsp";
    }

    @RequestMapping("/findById")
    public String findById(@RequestParam(value = "id") int id,
                           HttpServletRequest request){
        Student student = studentService.findById(id);
        request.setAttribute("student",student);
        return "test.jsp";
    }
}
