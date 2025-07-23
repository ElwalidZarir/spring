package com.example.demo.model;

import java.lang.reflect.Constructor;

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

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "OWNER")
    private String owner;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "LIKES")
    private int likes;

    public Post(String owner, String text) {
        this.owner = owner;
        this.text = text;
    }

    @ManyToOne 
    @JoinColumn(name="user_id")
    private User user;
}
