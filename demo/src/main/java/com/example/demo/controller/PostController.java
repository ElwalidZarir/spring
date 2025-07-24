package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PostDto;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public Post createPost(@RequestBody PostDto postDTO) {
        return postService.createPost(postDTO);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @GetMapping("/posts/{id}/likes")
    public ResponseEntity<Integer> getlikes(@PathVariable int id) {
        return postService.getLikesById(id);
    }

    @PutMapping("/posts/{id}/like")
    public ResponseEntity<Post> incrementLikes(@PathVariable int id) {
        return postService.incremtLikes(id);

        /*
         * Optional<Post> postOptional = postRepository.findById(id);
         * if (postOptional.isEmpty()) {
         * return ResponseEntity.notFound().build();
         * }
         * Post post = postOptional.get();
         * post.setLikes(post.getLikes() + 1); // not thread-safe
         * postRepository.save(post);
         * 
         * return ResponseEntity.ok(post);
         */

    }

}
