package com.mutlu.facebookapp.repository;

import com.mutlu.facebookapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
