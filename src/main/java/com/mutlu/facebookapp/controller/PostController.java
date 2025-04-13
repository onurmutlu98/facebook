package com.mutlu.facebookapp.controller;

import com.mutlu.facebookapp.dto.PostDto;
import com.mutlu.facebookapp.entity.Post;
import com.mutlu.facebookapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public Post createPost(@RequestBody Map<String, String> request) {
        int userId = Integer.parseInt(request.get("userId"));
        String title = request.get("title");
        String content = request.get("content");
        return postService.createPost(userId,title, content);
    }

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{userId}")
    public List<PostDto> getPostDtosByUser(@PathVariable int userId) {
        return postService.getPostDtosByUserId(userId);
    }


    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable int postId) {
        return postService.deletePost(postId);
    }
}
