package com.mutlu.facebookapp.controller;

import com.mutlu.facebookapp.dto.FriendDto;
import com.mutlu.facebookapp.entity.User;
import com.mutlu.facebookapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAll(){
        return service.getUsers();
    }
    @PostMapping
    public User create(@RequestBody User user){
        return service.saveUser(user);
    }

    @PostMapping("/list")
    public FriendDto getFriends(@RequestBody Map<String, Integer> request){
        Integer userId = request.get("user_id");
        return service.getFriends(userId);

    }
}
