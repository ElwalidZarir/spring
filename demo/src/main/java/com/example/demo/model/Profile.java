package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bio;

    @OneToMany(mappedBy = "profile")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "profile")
    private List<Skill> skills;

    @OneToMany(mappedBy = "profile")
    private List<Post> posts;

    @ManyToMany()
    @JoinTable(name="group_profile", joinColumns = @JoinColumn(name="profile_id"), inverseJoinColumns = @JoinColumn(name="group_id"))
    private List<Group> groups;
}
