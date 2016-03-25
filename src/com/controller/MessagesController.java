package com.controller;

import com.models.Messages;
import com.service.MessagesService;
import com.utils.Dates;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MessagesController {
    private MessagesService messagesService;

    public MessagesService getMessagesService() {
        return messagesService;
    }

    public void setMessagesService(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @RequestMapping("/addMessage")
    public String addMessage(Messages messages){
        messages.setTimes(Dates.getDate());
        messagesService.addMessage(messages);
        return "test.jsp";
    }

    @RequestMapping("/deleteMessage")
    public void deleteMessage(int id){
        messagesService.deleteMessage(id);
    }

    @RequestMapping("/findMessages")
    public String findMessages(@RequestParam(value = "info") String info,
                               HttpServletRequest request){
        List<Messages> list = messagesService.findMessages(info);
        request.setAttribute("messages",list);
        return "test.jsp";
    }

    @RequestMapping("/getMessage")
    public String getMessage(@RequestParam(value = "id") int id,
                             HttpServletRequest request){
        Messages messages = messagesService.getMessage(id);
        request.setAttribute("message",messages);
        return "test.jsp";
    }

    @RequestMapping("/reply")
    public String reply(@RequestParam(value = "id") int id,
                        @RequestParam(value = "content") String content){
        messagesService.reply(id,content);
        return "test.jsp";
    }
}
