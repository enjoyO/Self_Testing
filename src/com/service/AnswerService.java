package com.service;

import com.mapper.AnswerMapper;

public class AnswerService {
    private AnswerMapper answerMapper;

    public AnswerMapper getAnswerMapper() {
        return answerMapper;
    }

    public void setAnswerMapper(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }
}
