package com.service;

import com.mapper.TestPaperMapper;

public class TestPaperService {
    private TestPaperMapper testPaperMapper;

    public TestPaperMapper getTestPaperMapper() {
        return testPaperMapper;
    }

    public void setTestPaperMapper(TestPaperMapper testPaperMapper) {
        this.testPaperMapper = testPaperMapper;
    }
}
