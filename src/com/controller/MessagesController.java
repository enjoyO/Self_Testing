package com.controller;

import com.service.MessagesService;
import org.springframework.stereotype.Controller;

@Controller
public class MessagesController {
    private MessagesService messagesService;

    public MessagesService getMessagesService() {
        return messagesService;
    }

    public void setMessagesService(MessagesService messagesService) {
        this.messagesService = messagesService;
    }
}
