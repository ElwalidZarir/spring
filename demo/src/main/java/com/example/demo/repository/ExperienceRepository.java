package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
}
