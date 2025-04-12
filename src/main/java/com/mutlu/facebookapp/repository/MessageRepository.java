package com.mutlu.facebookapp.repository;

import com.mutlu.facebookapp.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findBySenderIdAndRecipientIdOrderByTimestampAsc(int senderId, int recipientId);
    List<Message> findByRecipientIdAndSenderIdOrderByTimestampAsc(int recipientId, int senderId);
}
