package com.example.oneToMany.repository;

import com.example.oneToMany.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    // Custom queries can be added here if needed
    List<Exercise> findByName(String name);

}
