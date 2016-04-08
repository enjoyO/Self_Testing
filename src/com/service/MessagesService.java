package com.service;

import com.mapper.MessagesMapper;
import com.models.Messages;
import com.models.MessagesExample;

import java.util.List;

public class MessagesService {
    private MessagesMapper messagesMapper;

    public MessagesMapper getMessagesMapper() {
        return messagesMapper;
    }

    public void setMessagesMapper(MessagesMapper messagesMapper) {
        this.messagesMapper = messagesMapper;
    }

    public void addMessage(Messages messages){
        messagesMapper.insert(messages);
    }

    public void deleteMessage(int id){
        messagesMapper.deleteByPrimaryKey(id);
    }

    public List<Messages> findMessages(String info){
        MessagesExample messagesExample = new MessagesExample();
        MessagesExample.Criteria criteria = messagesExample.createCriteria();
        criteria.andMessageLike(info);
        List<Messages> list = messagesMapper.selectByExample(messagesExample);
        return list;
    }

    public Messages getMessage(int id){
        Messages messages = messagesMapper.selectByPrimaryKey(id);
        return messages;
    }

    public void reply(Messages messages){
        messagesMapper.updateByPrimaryKeySelective(messages);
    }

    public List<Messages> getAllMessages(){
        MessagesExample messagesExample = new MessagesExample();
        MessagesExample.Criteria criteria = messagesExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Messages> list = messagesMapper.selectByExample(messagesExample);
        return list;
    }
}