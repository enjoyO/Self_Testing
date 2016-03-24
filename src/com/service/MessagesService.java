package com.service;

import com.mapper.MessagesMapper;

public class MessagesService {
    private MessagesMapper messagesMapper;

    public MessagesMapper getMessagesMapper() {
        return messagesMapper;
    }

    public void setMessagesMapper(MessagesMapper messagesMapper) {
        this.messagesMapper = messagesMapper;
    }
}
