package com.service;

import com.mapper.TeacherMapper;

public class TeacherService {
    private TeacherMapper teacherMapper;

    public TeacherMapper getTeacherMapper() {
        return teacherMapper;
    }

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }
}
