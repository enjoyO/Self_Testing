package com.controller;

import com.models.Student;
import com.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
                      HttpSession session) throws Exception {
        Student student = studentService.login(id, password);
        if (student == null) {
            response.getWriter().print("wrong");
        } else {
            session.setAttribute("student", student);
        }
    }

    @RequestMapping("/addStudent")
    public String addStudent(Student student) {
        studentService.addStudent(student);
        return "/getAllStudents.action";
    }

    @RequestMapping("/deleteStudent")
    public void deleteStudent(@RequestParam(value = "id") int id) {
        studentService.deleteStudent(id);
    }

    @RequestMapping("/deleteStudents")
    public void deleteStudents(@RequestParam(value = "ids") String ids) {
        if(ids.equals("")) return;
        String[] a = ids.split(",");
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(a[i]);
        }
        studentService.deleteStudents(b);
    }

    @RequestMapping("/modifyStudent")
    public String modifyStudent(@RequestParam(value = "id") int id,
                                HttpServletRequest request) {
        Student student = studentService.modify(id);
        request.setAttribute("modify", student);
        return "test.jsp";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(Student student) {
        studentService.update(student);
        return "/getAllStudents.action";
    }

    @RequestMapping("/findByIdAndName")
    public String findByIdAndName(Student student,
                                  HttpServletRequest request){
        List<Student> list = new ArrayList<>();
        if(student.getId()==null&&student.getName().equals("")){
            list = studentService.getAllStudents();
            request.setAttribute("allStudents",list);
        }
        else if(student.getId()==null){
            list = studentService.findByName(student.getName());
            request.setAttribute("allStudents",list);
        }
        else if(student.getName().equals("")){
            if(studentService.findById(student.getId())!=null) {
                list.add(studentService.findById(student.getId()));
                request.setAttribute("allStudents", list);
            }
        }
        else{
            if(studentService.findByIdAndName(student.getId(),student.getName())!=null) {
                list.add(studentService.findByIdAndName(student.getId(), student.getName()));
                request.setAttribute("allStudents", list);
            }
        }
        return "right（用户）.jsp";
    }

    @RequestMapping("/findByName")
    public String findByName(@RequestParam(value = "name") String name,
                             HttpServletRequest request) {
        List<Student> list = studentService.findByName(name);
        request.setAttribute("students", list);
        return "test.jsp";
    }

    @RequestMapping("/findById")
    public String findById(@RequestParam(value = "id") int id,
                           HttpServletRequest request) {
        Student student = studentService.findById(id);
        request.setAttribute("student", student);
        return "test.jsp";
    }

    @RequestMapping("/getAllStudents")
    public String getAllStudents(HttpServletRequest request) {
        List<Student> list = studentService.getAllStudents();
        request.setAttribute("allStudents", list);
        return "right（用户）.jsp";
    }
}
