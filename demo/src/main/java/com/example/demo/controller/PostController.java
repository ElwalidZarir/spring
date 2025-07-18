package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PostDto;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping("/post")
    public Post createPost(@RequestBody PostDto postDTO) {
        Post post = new Post();
        post.setOwner(postDTO.getOwner());
        post.setText(postDTO.getText());
        post.setLikes(0);
        return postRepository.save(post);
    }

    @GetMapping("/post/{id}/likes")
    public ResponseEntity<Integer> getlikes(@PathVariable int id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postOptional.get().getLikes());
    }

    @PutMapping("/post/{id}/like")
    public ResponseEntity<Post> incrementLikes(@PathVariable int id) {
        int updated = postRepository.incrementLikes(id);

        if (updated == 0) {
            return ResponseEntity.notFound().build();
        }
        return postRepository.findById(id)
                .map(post -> ResponseEntity.ok(post))
                .orElse(ResponseEntity.internalServerError().build());

        /*
         * Optional<Post> postOptional = postRepository.findById(id);
         * if (postOptional.isEmpty()) {
         * return ResponseEntity.notFound().build();
         * }
         * Post post = postOptional.get();
         * post.setLikes(post.getLikes() + 1);
         * postRepository.save(post);
         * 
         * return ResponseEntity.ok(post);
         */

    }

}
