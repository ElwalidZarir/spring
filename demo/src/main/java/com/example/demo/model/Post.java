package com.example.demo.model;

import java.lang.reflect.Constructor;
import java.util.Objects;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private int likes;

    public Post(String text) {
        this.text = text;
    }

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
