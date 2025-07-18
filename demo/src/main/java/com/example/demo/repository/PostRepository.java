package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Post;

import org.springframework.transaction.annotation.Transactional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.likes = p.likes + 1 WHERE p.id = :id")
    int incrementLikes(@Param("id") int id);
}
