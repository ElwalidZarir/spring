package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.PostDto;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(int id) {
        return postRepository.findById(id);
    }

    public Post createPost(PostDto postDto) {
        Post post = new Post();
        post.setOwner(postDto.getOwner());
        post.setText(postDto.getText());
        return postRepository.save(post);
    }
}
