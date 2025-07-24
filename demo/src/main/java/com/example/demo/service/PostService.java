package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PostDto;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public ResponseEntity<Post> getPostById(int id) {
        return postRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public Post createPost(PostDto postDto) {
        Post post = new Post();
        post.setOwner(postDto.getOwner());
        post.setText(postDto.getText());
        return postRepository.save(post);
    }

    public ResponseEntity<Integer> getLikesById(int id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postOptional.get().getLikes());
    }

    public ResponseEntity<Post> incremtLikes(int id) {
        int newLikes = postRepository.incrementLikes(id);

        if (newLikes == 0) {
            return ResponseEntity.notFound().build();
        }
        return postRepository.findById(id)
                .map(post -> ResponseEntity.ok(post))
                .orElse(ResponseEntity.internalServerError().build());
    }
}
