package com.example.basics.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotEmpty
  private String name;

  @NotEmpty
  private String address;

  @OneToMany(mappedBy = "user")
  private List<Competence> competences;

  @OneToMany(mappedBy = "sender")
  private List<RequestExchange> requestsSent;

  @OneToMany(mappedBy = "receiver")
  private List<RequestExchange> requestsReceived;
}
