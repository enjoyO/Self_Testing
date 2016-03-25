package com.service;

import com.mapper.QuestionBankMapper;
import com.models.QuestionBank;
import com.models.QuestionBankExample;

import java.util.List;

public class QuestionBankService {
    private QuestionBankMapper questionBankMapper;

    public QuestionBankMapper getQuestionBankMapper() {
        return questionBankMapper;
    }

    public void setQuestionBankMapper(QuestionBankMapper questionBankMapper) {
        this.questionBankMapper = questionBankMapper;
    }

    public void addQuestion(QuestionBank questionBank){
        questionBankMapper.insert(questionBank);
    }

    public void deleteQuestion(int id){
        questionBankMapper.deleteByPrimaryKey(id);
    }

    public QuestionBank modifyQuestion(int id){
        QuestionBank questionBank = questionBankMapper.selectByPrimaryKey(id);
        return questionBank;
    }

    public void updateQuestion(QuestionBank questionBank){
        questionBankMapper.updateByPrimaryKeySelective(questionBank);
    }

    public List<QuestionBank> findQuestions(String content){
        QuestionBankExample questionBankExample = new QuestionBankExample();
        QuestionBankExample.Criteria criteria = questionBankExample.createCriteria();
        criteria.andContentLike(content);
        List<QuestionBank> list = questionBankMapper.selectByExample(questionBankExample);
        return list;
    }

    public List<QuestionBank> getAllQuestions(){
        QuestionBankExample questionBankExample = new QuestionBankExample();
        QuestionBankExample.Criteria criteria = questionBankExample.createCriteria();
        criteria.andIdIsNotNull();
        List<QuestionBank> list = questionBankMapper.selectByExample(questionBankExample);
        return list;
    }
}
