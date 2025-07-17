package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ScoreController {
    static Score score = new Score(30, 20, 10);

    @GetMapping("/health-check")
    public String getHealthCheck() {
        return "Situation Normal";
    }

    @GetMapping("/score")
    public Score getScore() {
        return score;
    }

    @PostMapping("/score/win")
    public Score increasWin() {
        score.wins++;
        return score;
    }

    @GetMapping("/score/{endpoint}")
    public int getEndPoint(@PathVariable String endpoint) {
        if (endpoint.equals("wins")) {
            return score.wins;   
        } else if (endpoint.equals("ties")) {
            return score.ties;
        } else {
            return score.losses;
        }
    }

}
