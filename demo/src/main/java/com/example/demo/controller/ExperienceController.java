package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ExperienceDTO;
import com.example.demo.model.Experience;
import com.example.demo.repository.ExperienceRepository;
import com.example.demo.service.ExperienceService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ExperienceController {

    private final ExperienceRepository experienceRepository;
    @Autowired
    private ExperienceService experienceService;

    ExperienceController(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @PostMapping("/profiles/{id}/experiences")
    public Experience createExperience(@PathVariable int id, @RequestBody ExperienceDTO experienceDto) {
        return experienceService.createExperience(id, experienceDto);
    }

    @PutMapping("/profiles/{profileId}/experiences/{experieceId}")
    public Experience updaExperience(@PathVariable int experieceId, @RequestBody ExperienceDTO experienceDto) {
        return experienceService.updateExperience(experieceId, experienceDto);
    }

    
/* 
    @PutMapping("/profiles/{id}/experiences")
    public List<Experience> updateExperiences(@PathVariable int id, @RequestBody List<ExperienceDTO> experienceDTOs) {
        return experienceService.updateExperiences(id, experienceDTOs);
    } */

}
