package com.mutlu.facebookapp.service;

import com.mutlu.facebookapp.dto.MessageViewDto;
import com.mutlu.facebookapp.entity.Message;
import com.mutlu.facebookapp.entity.User;
import com.mutlu.facebookapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    @Autowired
    private UserService userService;

    public Message sendMessage(int senderId, int recipientId, String content) {
        User sender = userService.getUserById(senderId);
        User recipient = userService.getUserById(recipientId);

        Message message = new Message(content, LocalDateTime.now(), sender, recipient);
        return repository.save(message);
    }

    public List<MessageViewDto> getMessageContentsBetweenUsers(int userId1, int userId2) {
        List<Message> messages1 = repository.findBySenderIdAndRecipientIdOrderByTimestampAsc(userId1, userId2);
        List<Message> messages2 = repository.findBySenderIdAndRecipientIdOrderByTimestampAsc(userId2, userId1);

        List<Message> allMessages = new ArrayList<>();
        allMessages.addAll(messages1);
        allMessages.addAll(messages2);

        // Zaman sırasına göre tüm mesajları sırala
        allMessages.sort(Comparator.comparing(Message::getTimestamp));

        return allMessages.stream()
                .map(msg -> new MessageViewDto(msg.getSender().getId(),msg.getContent(), msg.getTimestamp()))
                .collect(Collectors.toList());
    }

}

