package com.example.basics;




import com.example.basics.config.RsaKeysConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeysConfig.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BasicsApplication{



  //Spring démarre au démarrage de l'application
  public static void main(String[] args) {
    SpringApplication.run(BasicsApplication.class, args);
  }

  //@Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }



  }

