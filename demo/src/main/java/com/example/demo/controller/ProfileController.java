package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProfileDTO;
import com.example.demo.model.Profile;
import com.example.demo.service.ProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProfileController {
    @Autowired 
    private ProfileService profileService;
    
    @PostMapping("/profiles")
    public Profile createProfile(@RequestBody ProfileDTO profileDto) {
        return profileService.createProfile(profileDto);
    }
    
    
}
