package com.example.basics.security.repositories;

import com.example.basics.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

  AppUser findByUsername(String username);

}
