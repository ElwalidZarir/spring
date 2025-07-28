package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(@RequestBody UserDTO userDto) {
        User user = new User(userDto.email(), userDto.username());
        return userRepository.save(user);
    }

    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }
}
