package com.mutlu.facebookapp.service;

import com.mutlu.facebookapp.dto.PostDto;
import com.mutlu.facebookapp.entity.Post;
import com.mutlu.facebookapp.entity.User;
import com.mutlu.facebookapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    @Autowired
    private UserService userService;

    public Post createPost(int userId,String title, String content) {
        User user = userService.getUserById(userId);
        Post post = new Post();
        post.setContent(content);
        post.setTitle(title);
        post.setTimestamp(LocalDateTime.now());
        post.setUser(user);
        return repository.save(post);
    }

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    public List<PostDto> getPostDtosByUserId(int userId) {
        // Veritabanından gelen tüm postları al
        List<Post> posts = repository.findByUserIdOrderByTimestampDesc(userId);

        // Post objelerinden sadece gerekli bilgileri alarak PostDto oluştur
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : posts) {
            // Post'tan gerekli verileri al
            String username = post.getUser().getUsername(); // Kullanıcı adı
            String content = post.getContent();            // Mesaj içeriği
            String title= post.getTitle();
            LocalDateTime timestamp = post.getTimestamp(); // Zaman damgası

            // Yeni PostDto objesi oluştur ve listeye ekle
            PostDto postDto = new PostDto(username,title, content, timestamp);
            postDtos.add(postDto);
        }

        // DTO listesine dönüş yap
        return postDtos;
    }


    public String deletePost(int postId) {
        repository.deleteById(postId);
        return "Post deleted successfully";
    }

    public Post getPostById(int postId) {
        return repository.findById(postId).get();
    }
}
