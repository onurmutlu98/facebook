package com.mutlu.facebookapp.controller;

import com.mutlu.facebookapp.dto.MessageViewDto;
import com.mutlu.facebookapp.entity.Message;
import com.mutlu.facebookapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping("/send")
    public Message sendMessage(@RequestBody Map<String, Object> request) {
        int senderId = (int) request.get("senderId");
        int receiverId = (int) request.get("receiverId");
        String content = (String) request.get("content");

        return service.sendMessage(senderId, receiverId, content);
    }


    @PostMapping("/between")
    public List<MessageViewDto> getMessagesBetweenUsers(@RequestBody Map<String, Integer> request) {
        int userId1= (int) request.get("userId1");
        int userId2= (int) request.get("userId2");
        return service.getMessageContentsBetweenUsers(userId1, userId2);
    }
}
