package com.service;

import com.mapper.AnswerMapper;
import com.models.Answer;
import com.models.AnswerExample;

import java.util.List;

public class AnswerService {
    private AnswerMapper answerMapper;

    public AnswerMapper getAnswerMapper() {
        return answerMapper;
    }

    public void setAnswerMapper(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    public void addAnswer(Answer answer){
        answerMapper.insert(answer);
    }

    public List<Answer> findByStudentId(int StuId){
        AnswerExample answerExample = new AnswerExample();
        AnswerExample.Criteria criteria = answerExample.createCriteria();
        criteria.andStudentIdEqualTo(StuId);
        List<Answer> list = answerMapper.selectByExample(answerExample);
        return list;
    }

    public List<Answer> getAllAnswers(){
        AnswerExample answerExample = new AnswerExample();
        AnswerExample.Criteria criteria = answerExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Answer> list = answerMapper.selectByExample(answerExample);
        return list;
    }
}
