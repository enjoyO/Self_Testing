package com.service;

import com.mapper.TeacherMapper;
import com.models.Teacher;
import com.models.TeacherExample;

import java.util.List;

public class TeacherService {
    private TeacherMapper teacherMapper;

    public TeacherMapper getTeacherMapper() {
        return teacherMapper;
    }

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public void addTeacher(Teacher teacher){
        teacherMapper.insert(teacher);
    }

    public void deleteTeacher(int id){
        teacherMapper.deleteByPrimaryKey(id);
    }

    public Teacher modifyTeacher(int id){
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        return teacher;
    }

    public void updateTeacher(Teacher teacher){
        teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    public List<Teacher> findTeachers(String name){
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andUsernameLike(name);
        List<Teacher> list = teacherMapper.selectByExample(teacherExample);
        return list;
    }

    public List<Teacher> getAllTeacher(){
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Teacher> list = teacherMapper.selectByExample(teacherExample);
        return list;
    }
}
