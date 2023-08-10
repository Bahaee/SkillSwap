package com.example.basics;

import com.example.basics.entities.User;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.basics.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BasicsApplication implements CommandLineRunner{

  @Autowired
  private UserRepository userRepository;

  //Spring démarre au démarrage de l'application
  public static void main(String[] args) {
    SpringApplication.run(BasicsApplication.class, args);
  }

  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Transactional
  @Override
  public void run(String... args) throws Exception {
    /*userRepository.save(new User(null,"Mohamed","Agdal Rabat",new Date(),null, null, null));
    userRepository.save(new User(null,"Sadik","Ben Slimane Rabat",new Date(),null, null, null));
    userRepository.save(new User(null,"Toubil","Valo Casa",new Date(),null, null, null));

    List<User> users =userRepository.findAll();
    users.forEach(u->{
      System.out.println(u.toString());
    });

    User user = userRepository.findById(Long.valueOf(1)).get();
    System.out.println(user.toString());

    System.out.println("****************************");
    List<User> userList = userRepository.findByNameContains("M");
    userList.forEach(u->{
      System.out.println(u);
    });
    System.out.println("****************************");
    List<User> userList2 = userRepository.search("%M%");
    userList2.forEach(u->{
      System.out.println(u);
    });*/

  }
}
