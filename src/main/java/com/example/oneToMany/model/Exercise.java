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
public class Exercise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(
      fetch = FetchType.LAZY,
      mappedBy = "exercise",
      cascade = CascadeType.ALL
  )
  private List<Step> steps = new ArrayList<>();

  public Exercise(String name) {
    this.name = name;
  }

  public Exercise() {
  }

  public Exercise(Long id, String name, List<Step> steps) {
    this.id = id;
    this.name = name;
    this.steps = steps;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Step> getSteps() {
    return steps;
  }

  public void setSteps(List<Step> steps) {
    this.steps = steps;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Exercise exercise = (Exercise) o;
    return Objects.equals(getId(), exercise.getId()) && Objects.equals(getName(), exercise.getName())
        && Objects.equals(getSteps(), exercise.getSteps());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getSteps());
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Exercise.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("name='" + name + "'")
        .add("steps=" + steps)
        .toString();
  }
}
