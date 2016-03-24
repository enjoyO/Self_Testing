package com.service;

import com.mapper.StudentMapper;
import com.models.Student;
import com.models.StudentExample;

import java.util.List;

public class StudentService {
    private StudentMapper studentMapper;

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public Student login(int id, String password) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andIdEqualTo(id).andPasswordEqualTo(password);
        List<Student> list = studentMapper.selectByExample(studentExample);
        if (list.size() == 0) return null;
        else return list.get(0);
    }

    public void addStudent(Student student) {
        studentMapper.insert(student);
    }

    public void deleteStudent(int id) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andIdEqualTo(id);
        studentMapper.deleteByExample(studentExample);
    }

    public Student modify(int id){
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

    public void update(Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }

    public List<Student> findByName(String name) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andNameLike(name);
        List<Student> list = studentMapper.selectByExample(studentExample);
        return list;
    }

    public Student findById(int id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }
}