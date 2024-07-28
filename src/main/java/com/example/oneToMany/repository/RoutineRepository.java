package com.example.oneToMany.repository;

import com.example.oneToMany.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {

  List<Routine> findByName(String name);
}