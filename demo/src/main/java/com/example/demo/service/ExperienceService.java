package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ExperienceDTO;
import com.example.demo.model.Experience;
import com.example.demo.model.Profile;
import com.example.demo.repository.ExperienceRepository;
import com.example.demo.repository.ProfileRepository;

@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public Experience createExperience(int profileId, ExperienceDTO experienceDto) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        Experience experience = new Experience();
        experience.setJobTitle(experienceDto.getJobTitle());
        experience.setProfile(profile);
        return experienceRepository.save(experience);
    }

    public Experience updatExperience(int experienceId, ExperienceDTO experienceDto) {
        Experience experience = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new RuntimeException("Experience not found"));
        experience.setJobTitle(experienceDto.getJobTitle());
        return experienceRepository.save(experience);
    }

    public List<Experience> updateExperiences(int profileId, List<ExperienceDTO> experienceDtos) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        List<Experience> newExperiences = experienceDtos.stream()
                .map(dto -> {
                    Experience exp = new Experience();
                    exp.setJobTitle(dto.getJobTitle());
                    exp.setProfile(profile);
                    return exp;
                })
                .collect(Collectors.toList());
        return experienceRepository.saveAll(newExperiences);

    }
}
