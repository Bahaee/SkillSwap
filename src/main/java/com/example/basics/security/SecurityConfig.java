package com.example.basics.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private UserDetailsService userDetailsService;


  //@Bean
  public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
    return new InMemoryUserDetailsManager(
        User.withUsername("Bahae").password(passwordEncoder.encode("1234")).roles("USER").build(),
        User.withUsername("Riyad").password(passwordEncoder.encode("1234")).roles("USER").build(),
        User.withUsername("Mouna").password(passwordEncoder.encode("1234")).roles("USER","ADMIN").build()
    );
  }


  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
    httpSecurity.formLogin();
    httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
    httpSecurity.userDetailsService(userDetailsService);
    return httpSecurity.build(); //retourner le filtre d'objet SecurityFilterChain
  }

}




