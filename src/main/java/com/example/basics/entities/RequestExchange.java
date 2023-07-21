package com.example.basics.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RequestExchange {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "senderId")
  private User sender;

  @ManyToOne
  @JoinColumn(name = "receiverId")
  private User receiver;

  @ManyToOne
  @JoinColumn(name = "competenceId")
  private Competence competence;

  private String statut;

}
