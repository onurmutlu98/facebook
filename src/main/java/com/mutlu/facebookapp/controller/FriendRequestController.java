package com.mutlu.facebookapp.controller;

import com.mutlu.facebookapp.entity.FriendRequest;
import com.mutlu.facebookapp.service.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/request")
public class FriendRequestController {

    @Autowired
    private FriendRequestService service;


    @PostMapping("/add")
    public FriendRequest addFriendRequest(@RequestBody Map<String, Integer> request) {
        int senderId = request.get("sender_id");
        int recipientId = request.get("recipient_id");

        return service.addFriendRequest(senderId, recipientId);
    }

    @PutMapping("/update")
    public String updateFriendRequest(@RequestBody Map<String, Integer> request) {
        int friendshipId = request.get("friendship_id");
        int status = request.get("status");
        return service.responseFriendRequest(friendshipId,status);
    }
}
