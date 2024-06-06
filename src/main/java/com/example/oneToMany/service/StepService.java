package com.example.oneToMany.service;

import com.example.oneToMany.model.Step;
import com.example.oneToMany.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StepService {
    private final StepRepository stepRepository;

    @Autowired
    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    public Step createStep(Step step) {
        return stepRepository.save(step);
    }

    public Step updateStep(Long id, Step updatedStep) {
        Optional<Step> existingStep = stepRepository.findById(id);
        if (existingStep.isPresent()) {
            Step step = existingStep.get();
            step.setName(updatedStep.getName());
            step.setExercise(updatedStep.getExercise());
            // Update other fields as needed
            return stepRepository.save(step);
        }
        return null; // Handle not found case
    }

    public List<Step> getAllSteps() {

        return stepRepository.findAll();
    }

    public Step getStepById(Long id) {
        return stepRepository.findById(id).orElse(null);
    }

    // Other methods (e.g., deleteStep, getStepByExercise) can be added as needed
}
