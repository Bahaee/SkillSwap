package com.example.basics.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AppUser {

  @Id
  private String userId;
  @Column(unique = true)
  private String username;
  private String password;
  @Column(unique = true)
  private String email;
  @ManyToMany(fetch = FetchType.EAGER)
  private List<AppRole> roles;
}
