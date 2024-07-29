package com.example.OneToMany.repository;

import com.example.OneToMany.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    // Custom queries can be added here if needed
    List<Exercise> findByName(String name);

}
