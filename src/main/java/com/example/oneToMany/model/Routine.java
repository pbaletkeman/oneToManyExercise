package com.example.oneToMany.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Routine {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @OneToMany (
      fetch =  FetchType.LAZY,
      mappedBy = "routine",
      cascade = CascadeType.ALL
  )
  private List<Exercise> exercises = new ArrayList<>();

  @Column(name = "reps")
  private int reps;

  public Routine(String name) {this.name = name;}

  public Routine(){

  }

  public Routine(long id, String name, List<Exercise> exercises, int reps) {
    this.id = id;
    this.name = name;
    this.exercises = exercises;
    this.reps = reps;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Exercise> getExercises() {
    return exercises;
  }

  public void setExercises(List<Exercise> exercises) {
    this.exercises = exercises;
  }

  public int getReps() {
    return reps;
  }

  public void setReps(int reps) {
    this.reps = reps;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Routine routine = (Routine) o;
    return getId() == routine.getId() && getReps() == routine.getReps() && Objects.equals(getName(),
        routine.getName()) && Objects.equals(getExercises(), routine.getExercises());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getExercises(), getReps());
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Routine.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("name='" + name + "'")
        .add("exercises=" + exercises)
        .add("reps=" + reps)
        .toString();
  }
}
