package com.example.oneToMany.service;

import com.example.oneToMany.model.Exercise;
import com.example.oneToMany.model.Routine;
import com.example.oneToMany.repository.ExerciseRepository;
import com.example.oneToMany.repository.RoutineRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutineService {

  private final RoutineRepository routineRepository;
  private final ExerciseRepository exerciseRepository;

  @Autowired
  public RoutineService(RoutineRepository routineRepository, ExerciseRepository exerciseRepository) {
    this.exerciseRepository = exerciseRepository;
    this.routineRepository = routineRepository;
  }

  public Routine createRoutine(Routine routine) {
    return routineRepository.save(routine);
  }

  public Routine updateRoutine(Long id, Routine updatedRoutine) {
    return updateRoutine(id, updatedRoutine, false);
  }

  public Routine updateRoutine(Long id, Routine updateRoutine, boolean updateExercise) {
    Optional<Routine> existingRoutine = routineRepository.findById(id);
    if (existingRoutine.isPresent()) {
      // Update other fields as needed
      Routine routine = existingRoutine.get();
      routine.setName((updateRoutine.getName()));
      if (updateExercise) {
        Exercise exercise;
        for (Long i : updateRoutine.getExercises().stream().map(Exercise::getId).toList()) {
          exercise = exerciseRepository.findById(i).orElse(null);
          if (exercise != null) {
            exercise.setRoutine(routine);
          }
        }
      }
      return routineRepository.save(routine);
    }
    return null; // handle not found case
  }

  public List<Routine> getAllRoutines() {
    return routineRepository.findAll();
  }

  public Routine getRoutineById(Long id) {
    return routineRepository.findById(id).orElse(null);
  }

  public void deleteRoutineById(Long id) {
    routineRepository.deleteById(id);
  }

  public void deleteManyRoutines(String ids){
    routineRepository.deleteAllById(Arrays.stream(ids.split(",")).map(Long::parseLong).toList());
  }
}
