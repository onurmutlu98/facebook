package com.mutlu.facebookapp.repository;

import com.mutlu.facebookapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserIdOrderByTimestampDesc(int userId);
}
