package com.service;

import com.mapper.SubjectMapper;
import com.models.Subject;
import com.models.SubjectExample;

import java.util.List;

public class SubjectService {
    private SubjectMapper subjectMapper;

    public SubjectMapper getSubjectMapper() {
        return subjectMapper;
    }

    public void setSubjectMapper(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    public void addSubject(Subject subject){
        subjectMapper.insert(subject);
    }

    public void deleteSubject(int id){
        subjectMapper.deleteByPrimaryKey(id);
    }

    public Subject modifySubject(int id){
        Subject subject = subjectMapper.selectByPrimaryKey(id);
        return subject;
    }

    public void updateSubject(Subject subject){
        subjectMapper.updateByPrimaryKeySelective(subject);
    }

    public List<Subject> findSubjects(String name){
        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria = subjectExample.createCriteria();
        criteria.andClassNameLike(name);
        List<Subject> list = subjectMapper.selectByExample(subjectExample);
        return list;
    }

    public List<Subject> getAllSubjects(){
        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria =subjectExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Subject> list = subjectMapper.selectByExample(subjectExample);
        return list;
    }
}
