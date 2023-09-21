package com.example.basics.security.services;

import com.example.basics.security.entities.AppRole;
import com.example.basics.security.entities.AppUser;
import com.example.basics.security.repositories.AppRoleRepository;
import com.example.basics.security.repositories.AppUserRepository;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

  private AppUserRepository appUserRepository;
  private AppRoleRepository appRoleRepository;
  private PasswordEncoder passwordEncoder;


  @Override
  public AppUser addNewUser(String username, String password, String email,
      String confirmPassword) {
    //Ce qu'on vient de définir par la suite sont les règles métiers
    AppUser appUser=appUserRepository.findByUsername(username);
    if(appUser!=null) throw new RuntimeException ("This user already exist !");
    if(!password.equals(confirmPassword)) throw new RuntimeException("Passwords not match !");
    appUser=AppUser.builder().
              userId(UUID.randomUUID().toString()).
              username(username).
              password(passwordEncoder.encode(password)).
              email(email).
              build();
    AppUser savedAppUser = appUserRepository.save(appUser);
    return savedAppUser;
  }

  @Override
  public AppRole addNewRole(String role) {
    AppRole appRole = appRoleRepository.findById(role).orElse(null);
    if(appRole!=null) throw new RuntimeException("This roel already exist !");
    appRole = appRole.builder().role(role).build();
    return appRoleRepository.save(appRole);
  }

  @Override
  public void addRoleToUser(String username, String role) {
    AppUser appUser = appUserRepository.findByUsername(username);
    AppRole appRole = appRoleRepository.findById(role).get();
    appUser.getRoles().add(appRole);
    //appUserRepository.save(appUser);
    // Cette etape est operationnel car la méthode est transactinelle
  }

  @Override
  public void removeRoleFromUser(String username, String role) {
    AppUser appUser = appUserRepository.findByUsername(username);
    AppRole appRole = appRoleRepository.findById(role).get();
    appUser.getRoles().remove(appRole);
  }

  @Override
  public AppUser loadUserByUsername(String username) {
    return appUserRepository.findByUsername(username);
  }
}
