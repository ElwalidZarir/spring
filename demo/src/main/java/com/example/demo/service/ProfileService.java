package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProfileDTO;
import com.example.demo.model.Profile;
import com.example.demo.repository.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Profile createProfile(ProfileDTO profileDto){
        Profile profile = new Profile();
        profile.setBio(profileDto.getBio());
        return profileRepository.save(profile);
    }

    
}
