package com.service;

import com.mapper.MarkMapper;

public class MarkService {
    private MarkMapper markMapper;

    public MarkMapper getMarkMapper() {
        return markMapper;
    }

    public void setMarkMapper(MarkMapper markMapper) {
        this.markMapper = markMapper;
    }
}
