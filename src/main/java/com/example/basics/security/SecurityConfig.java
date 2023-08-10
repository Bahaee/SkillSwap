package com.example.basics.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
    return new InMemoryUserDetailsManager(
        User.withUsername("bahae").password("{noop}1234").roles("USER").build(),
        User.withUsername("riyad").password("{noop}1234").roles("USER").build(),
        User.withUsername("mouna").password("{noop}1234").roles("USER","ADMIN").build()
    );
  }


  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
    httpSecurity.formLogin();
    httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
    return httpSecurity.build(); //retourner le filtre d'objet SecurityFilterChain
  }
}
