package com.example.basics.security.services;

import com.example.basics.security.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service @AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

  private AccountService accountService;

  //Personnaliser cette methode de retreive des crendentials qui est deja defini f inmemoryauth and jdbcauth
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser appUser= accountService.loadUserByUsername(username);
    if(appUser!=null) throw new UsernameNotFoundException(String.format("User %s not found", username));

    String[] roles = appUser.getRoles().stream().map(u -> u.getRole()).toArray(String[]::new);
    // I want to return a table of Strings

    UserDetails userDetails = User.
        withUsername(appUser.getUsername()).
        password(appUser.getPassword()).
        roles(roles).build();
    return userDetails;
  }
}
