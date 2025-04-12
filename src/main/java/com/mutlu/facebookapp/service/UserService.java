package com.mutlu.facebookapp.service;

import com.mutlu.facebookapp.dto.FriendDto;
import com.mutlu.facebookapp.dto.UserDto;
import com.mutlu.facebookapp.entity.FriendRequest;
import com.mutlu.facebookapp.entity.User;
import com.mutlu.facebookapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private FriendRequestService friendRequestService;

    public User saveUser(User user) {
        return repository.save(user);
    }
    public List<User> getUsers() {
        return repository.findAll();
    }
    public User getUserById(int id) {
        return repository.findById(id).get();
    }
    public String deleteUserById(int id) {
        repository.deleteById(id);
        return "User deleted";
    }

    public FriendDto getFriends(Integer userId) {
        User user = repository.findById(userId).get();
        List<UserDto> userDtos = new ArrayList<>();

        FriendDto friendDto=new FriendDto();
        friendDto.setName(user.getFirstName() + " " + user.getLastName());
        for (FriendRequest friendRequest : friendRequestService.getFriendRequests()) {
           if(friendRequest.getStatus().equals(1)){
               if(friendRequest.getSender().getId()==user.getId()) {
                   UserDto user1 = new UserDto();
                   user1.setTotalName(friendRequest.getRecipient().getFirstName()+" "+friendRequest.getRecipient().getLastName());
                   userDtos.add(user1);
               }
               if(friendRequest.getRecipient().getId()==user.getId()) {
                   UserDto user2 = new UserDto();
                   user2.setTotalName(friendRequest.getSender().getFirstName()+" "+friendRequest.getSender().getLastName());
                   userDtos.add(user2);
               }
           }
           friendDto.setFriends(userDtos);
        }
        return friendDto;
    }
}
