package com.example.basics.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Competence {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotEmpty
  private String name;

  private String description;

  private String type;

  @ManyToOne
  @JoinColumn(name = "idUser")
  private User user;

}
