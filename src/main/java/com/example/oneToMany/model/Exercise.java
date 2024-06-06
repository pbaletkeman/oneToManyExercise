package com.example.oneToMany.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(
        fetch = FetchType.LAZY,
            mappedBy = "exercise",
            cascade = CascadeType.ALL
    )
    private List<Step> steps = new ArrayList<>();

    public Exercise(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public Exercise() {
    }

    public Exercise(Long id, String name, List<Step> steps) {
        this.id = id;
        this.name = name;
        this.steps = steps;
    }
}
