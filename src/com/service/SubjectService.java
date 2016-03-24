package com.service;

import com.mapper.SubjectMapper;

public class SubjectService {
    private SubjectMapper subjectMapper;

    public SubjectMapper getSubjectMapper() {
        return subjectMapper;
    }

    public void setSubjectMapper(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }
}
