package com.mutlu.facebookapp.dto;

import com.mutlu.facebookapp.entity.User;

import java.util.List;

public class FriendDto {
    private String name;
    private List<UserDto> friends;
    public FriendDto() {

    }
    public FriendDto(String name, List<User> friends) {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDto> getFriends() {
        return friends;
    }

    public void setFriends(List<UserDto> friends) {
        this.friends = friends;
    }
}
