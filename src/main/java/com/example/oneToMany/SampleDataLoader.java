package com.example.oneToMany;

import com.example.oneToMany.model.Step;
import com.example.oneToMany.model.Exercise;
import com.example.oneToMany.repository.StepRepository;
import com.example.oneToMany.repository.ExerciseRepository;
import java.util.ArrayList;
import java.util.Random;
import net.datafaker.Faker;
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
        Faker faker = new Faker();

        String name = "";

        // Create exercises
        List<Exercise> ex = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            name = faker.name().fullName();
            ex.add(new Exercise());
        }
        // Save exercises
        exerciseRepository.saveAll(ex);
        Random rand = new Random();

        // Create Steps
        List<Step> steps = new ArrayList<>();
        String description = "";
        for (int i = 0; i < 10; i++){
            for (long j = 1; j < rand.nextInt(7); j++) {
                name = faker.ancient().god() + " - " + faker.zodiac().sign();
                description = faker.bojackHorseman().quotes();
                steps.add(new Step(name, j, description, ex.get(i)));
            }
        }
        // Save steps
        stepRepository.saveAll(steps);
    }
}
