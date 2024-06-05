package com.example.oneToMany.controller;

import com.example.oneToMany.model.Instructor;
import com.example.oneToMany.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class ExerciseController {
    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    // Create a new exercise
    @PostMapping
    public ResponseEntity<Instructor> createExercise(@RequestBody Instructor instructor) {
        Instructor savedInstructor = exerciseService.createExercise(instructor);
        return ResponseEntity.ok(savedInstructor);
    }

    // Update an existing exercise
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateExercise(@PathVariable Long id, @RequestBody Instructor instructor) {
        Instructor updatedInstructor = exerciseService.updateExercise(id, instructor);
        return ResponseEntity.ok(updatedInstructor);
    }

    // List all exercise
    @GetMapping
    public ResponseEntity<List<Instructor>> getAllexercise() {
        List<Instructor> instructors = exerciseService.getAllExercises();
        return ResponseEntity.ok(instructors);
    }

    // View details of a specific exercise
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getExerciseById(@PathVariable Long id) {
        Instructor instructor = exerciseService.getExerciseById(id);
        if (instructor != null) {
            return ResponseEntity.ok(instructor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Other endpoints (e.g., delete, additional queries) can be added as needed
}
