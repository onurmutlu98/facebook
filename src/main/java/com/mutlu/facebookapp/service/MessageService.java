package com.mutlu.facebookapp.service;

import com.mutlu.facebookapp.entity.Message;
import com.mutlu.facebookapp.entity.User;
import com.mutlu.facebookapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserService userService;

    public Message sendMessage(int senderId, int recipientId, String content) {
        User sender = userService.getUserById(senderId);
        User recipient = userService.getUserById(recipientId);

        Message message = new Message(content, LocalDateTime.now(), sender, recipient);
        return messageRepository.save(message);
    }

    public List<Message> getMessagesBetweenUsers(int userId1, int userId2) {
        List<Message> messages = messageRepository.findBySenderIdAndRecipientIdOrderByTimestampAsc(userId1, userId2);
        messages.addAll(messageRepository.findByRecipientIdAndSenderIdOrderByTimestampAsc(userId1, userId2));
        return messages;
    }
}
