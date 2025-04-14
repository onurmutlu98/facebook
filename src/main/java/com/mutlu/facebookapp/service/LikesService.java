package com.mutlu.facebookapp.service;

import com.mutlu.facebookapp.dto.LikesDto;
import com.mutlu.facebookapp.entity.Likes;
import com.mutlu.facebookapp.entity.Post;
import com.mutlu.facebookapp.entity.User;
import com.mutlu.facebookapp.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LikesService {
    @Autowired
    private LikesRepository repository;
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    public Likes addLike(int postId, int likedById,int statusId) {
        User user = userService.getUserById(likedById);
        Post post = postService.getPostById(postId);
        Likes likes = new Likes();
        likes.setUser(user);
        likes.setPost(post);
        likes.setStatus(statusId);
        likes.setTimestamp(LocalDateTime.now());

        return repository.save(likes);
    }
    public LikesDto countLikesByPostId(int postId) {
        LikesDto likesDto = new LikesDto();
        Post post = postService.getPostById(postId);
        int likeCount= repository.countByPostIdAndStatus(postId, 1);
        int dislikeCount= repository.countByPostIdAndStatus(postId, 2);
        likesDto.setLikesNumber(likeCount);
        likesDto.setDislikesNumber(dislikeCount);
        likesDto.setPostComment(post.getContent());
        return likesDto;

    }


}
