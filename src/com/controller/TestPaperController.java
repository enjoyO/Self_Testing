package com.controller;

import com.service.TestPaperService;
import org.springframework.stereotype.Controller;

@Controller
public class TestPaperController {
    private TestPaperService testPaperService;

    public TestPaperService getTestPaperService() {
        return testPaperService;
    }

    public void setTestPaperService(TestPaperService testPaperService) {
        this.testPaperService = testPaperService;
    }
}
