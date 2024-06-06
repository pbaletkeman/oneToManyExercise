package com.example.oneToMany.repository;

import com.example.oneToMany.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StepRepository extends JpaRepository<Step, Long> {
    // Custom queries can be added here if needed
    List<Step> findByName(String name);


}
