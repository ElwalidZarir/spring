package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.GroupRepository;

@RestController
public class GroupController {
    @Autowired
    private GroupRepository groupRepository;
    
    

}
