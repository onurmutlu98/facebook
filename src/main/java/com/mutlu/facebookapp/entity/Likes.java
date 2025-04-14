package com.mutlu.facebookapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Integer status;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "likedby_id")
    private User user;
    @ManyToOne
    private Post post;
    public Likes() {}

    public Likes(int id, Integer status, User user, Post post, LocalDateTime timestamp) {
        this.id = id;
        this.status = status;
        this.user = user;
        this.post = post;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

