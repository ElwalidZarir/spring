package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
     AtomicInteger wins = new AtomicInteger(30);
     AtomicInteger ties = new AtomicInteger(20);
     AtomicInteger losses = new AtomicInteger(10);

    public Score() {
    }

    public Score(AtomicInteger wins, AtomicInteger ties, AtomicInteger losses) {
        this.wins = wins;
        this.ties = ties;
        this.losses = losses;
    }
}
