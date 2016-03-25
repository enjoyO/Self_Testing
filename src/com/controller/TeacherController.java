package com.controller;

import com.models.Teacher;
import com.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TeacherController {
    private TeacherService teacherService;

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("/addTeacher")
    public String addTeacher(Teacher teacher){
        teacherService.addTeacher(teacher);
        return "test,jsp";
    }

    @RequestMapping("/deleteTeacher")
    public void deleteTeacher(@RequestParam(value = "id") int id){
        teacherService.deleteTeacher(id);
    }

    @RequestMapping("/modifyTeacher")
    public String modifyTeacher(@RequestParam(value = "id") int id,
                                 HttpServletRequest request){
        Teacher teacher = teacherService.modifyTeacher(id);
        request.setAttribute("modify",teacher);
        return "test.jsp";
    }

    @RequestMapping("/updateTeacher")
    public String updateTeacher(Teacher teacher){
        teacherService.updateTeacher(teacher);
        return "test.jsp";
    }

    @RequestMapping("/findTeachers")
    public String findTeachers(@RequestParam(value = "name") String name,
                               HttpServletRequest request){
        List<Teacher> list = teacherService.findTeachers(name);
        request.setAttribute("teachers",list);
        return "test.jsp";
    }

    @RequestMapping("/getAllTeachers")
    public String getAllTeachers(HttpServletRequest request){
        List<Teacher> list = teacherService.getAllTeacher();
        request.setAttribute("allTeachers",list);
        return "test.jsp";
    }
}
