package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.Setter;

public record Score(AtomicInteger wins,  AtomicInteger ties,AtomicInteger losses) {

}
