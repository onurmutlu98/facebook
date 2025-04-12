package com.mutlu.facebookapp.service;

import com.mutlu.facebookapp.entity.User;
import com.mutlu.facebookapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

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
}
