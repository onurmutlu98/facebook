package com.mutlu.facebookapp.dto;

import java.time.LocalDateTime;

public class MessageViewDto {
    private int senderId;
    private String content;
    private LocalDateTime timestamp;

    public MessageViewDto(int senderId, String content, LocalDateTime timestamp) {
        this.senderId = senderId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
