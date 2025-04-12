package com.mutlu.facebookapp.service;

import com.mutlu.facebookapp.entity.FriendRequest;
import com.mutlu.facebookapp.entity.User;
import com.mutlu.facebookapp.repository.FriendRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendRequestService {

    @Autowired
    private FriendRequestRepository repository;

    @Autowired
    private UserService userService;

    public FriendRequest addFriendRequest(int sender_id, int recipient_id) {
        User sender= userService.getUserById(sender_id);
        User recipient= userService.getUserById(recipient_id);

        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setSender(sender);
        friendRequest.setRecipient(recipient);
        friendRequest.setStatus(0);
        return repository.save(friendRequest);

    }

    public String responseFriendRequest(int friendRequest_id,int status) {
        FriendRequest friendRequest = repository.findById(friendRequest_id).get();
        friendRequest.setStatus(status);
        repository.save(friendRequest);
        if(friendRequest.getStatus() == 1) {
            return "You have been accepted the friend request";
        }
        return "You have been rejected the friend request";
    }

    public List<FriendRequest> getFriendRequests(){
        return repository.findAll();
    }
    public FriendRequest getFriendRequest(int friendRequest_id) {
        return repository.findById(friendRequest_id).get();
    }
}
