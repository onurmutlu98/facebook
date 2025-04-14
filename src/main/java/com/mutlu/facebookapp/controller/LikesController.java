package com.mutlu.facebookapp.controller;

import com.mutlu.facebookapp.entity.Likes;
import com.mutlu.facebookapp.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/likes")
public class LikesController {
    @Autowired
    private LikesService service;

    @PostMapping
    public Likes addLike (@RequestBody Map<String, Integer> request) {
        int postId = request.get("postId");
        int likedById = request.get("likedById");
        int statusId = request.get("statusId");
        return service.addLike(postId,likedById,statusId);


    }
}
