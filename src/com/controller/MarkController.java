package com.controller;

import com.service.MarkService;
import org.springframework.stereotype.Controller;

@Controller
public class MarkController {
    private MarkService markService;

    public MarkService getMarkService() {
        return markService;
    }

    public void setMarkService(MarkService markService) {
        this.markService = markService;
    }
}
