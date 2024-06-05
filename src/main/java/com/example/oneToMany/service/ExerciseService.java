package com.example.oneToMany.service;

import com.example.oneToMany.model.Instructor;
import com.example.oneToMany.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Instructor createExercise(Instructor instructor) {
        return exerciseRepository.save(instructor);
    }

    public Instructor updateExercise(Long id, Instructor updatedInstructor) {
        Optional<Instructor> existingInstructor = exerciseRepository.findById(id);
        if (existingInstructor.isPresent()) {
            Instructor instructor = existingInstructor.get();
            instructor.setName(updatedInstructor.getName());
            // Update other fields as needed
            return exerciseRepository.save(instructor);
        }
        return null; // Handle not found case
    }

    public List<Instructor> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Instructor getExerciseById(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    // Other methods (e.g., deleteExercise, getExerciseSteps) can be added as needed
}
