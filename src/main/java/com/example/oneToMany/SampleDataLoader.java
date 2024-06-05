package com.example.oneToMany;

import com.example.oneToMany.model.Step;
import com.example.oneToMany.model.Instructor;
import com.example.oneToMany.repository.StepRepository;
import com.example.oneToMany.repository.ExerciseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private final ExerciseRepository exerciseRepository;
    private final StepRepository stepRepository;

    public SampleDataLoader(ExerciseRepository exerciseRepository, StepRepository stepRepository) {
        this.exerciseRepository = exerciseRepository;
        this.stepRepository = stepRepository;
    }

    @Override
    public void run(String... args) {
        // Create exercises
        Instructor johnDoe = new Instructor("John Doe");
        Instructor janeSmith = new Instructor("Jane Smith");
        Instructor michaelJohnson = new Instructor("Michael Johnson");

        // Save exercises
        exerciseRepository.saveAll(List.of(johnDoe, janeSmith, michaelJohnson));
//        instructorRepository.save(johnDoe);
        // Create Steps
        Step javaStep = new Step("Introduction to Java", johnDoe);
        Step webDevStep = new Step("Web Development Basics", johnDoe);
        Step dbStep = new Step("Database Design",janeSmith);

        // Save steps
        stepRepository.saveAll(List.of(javaStep, webDevStep, dbStep));
    }
}
