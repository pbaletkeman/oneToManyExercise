package com.example.oneToMany.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    @JsonBackReference
    private Exercise exercise;

    public Step(String title, Exercise exercise) {
        this.title = title;
        this.exercise = exercise;
    }

    public Step(String title) {
        this.title = title;
    }
    // Other fields, getters, setters...


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Step() {
    }

    public Step(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Step(Long id, String title, Exercise exercise) {
        this.id = id;
        this.title = title;
        this.exercise = exercise;
    }
}
