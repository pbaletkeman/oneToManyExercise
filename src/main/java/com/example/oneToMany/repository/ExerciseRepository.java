package com.example.oneToMany.repository;

import com.example.oneToMany.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Instructor, Long> {
    // Custom queries can be added here if needed
    List<Instructor> findByName(String name);

}
