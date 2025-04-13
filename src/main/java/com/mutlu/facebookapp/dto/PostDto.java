package com.mutlu.facebookapp.dto;

import java.time.LocalDateTime;

public class PostDto {
    private String username;
    private String title;
    private String content;
    private LocalDateTime timestamp;

    public PostDto(String username, String title, String content, LocalDateTime timestamp) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
