package com.mutlu.facebookapp.repository;

import com.mutlu.facebookapp.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer> {
    int countByPostIdAndStatus(int postId, int i);

}
