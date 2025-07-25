package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
public class ScoreController {
    static Score score = new Score(new AtomicInteger(30),new AtomicInteger(20),new AtomicInteger(1));

    @GetMapping("/health-check")
    public String getHealthCheck() {
        return "Situation Normal";
    }

    @GetMapping("/score")
    public Score getScore() {
        return score;
    }

    @PostMapping("/score/wins")
    public Score increasWin() {
        score.ties().incrementAndGet();
        return score;
    }

    @GetMapping("/score/wins")
    public AtomicInteger getwins() {
        return score.wins();
    }

    @GetMapping("/score/losses")
    public AtomicInteger getLosses() {
        return score.losses();
    }

    @GetMapping("/score/ties")
    public AtomicInteger getTies() {
        return score.ties();
    }
    
    

}
