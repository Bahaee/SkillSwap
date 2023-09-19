package com.example.basics;

import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.basics.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class BasicsApplication implements CommandLineRunner{

  @Autowired
  private UserRepository userRepository;

  //Spring démarre au démarrage de l'application
  public static void main(String[] args) {
    SpringApplication.run(BasicsApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
    PasswordEncoder passwordEncoder = passwordEncoder();
    return args -> {
      UserDetails u1= jdbcUserDetailsManager.loadUserByUsername("user11");
      if(u1 == null)
        jdbcUserDetailsManager.createUser(
            User.withUsername("user11").password(passwordEncoder.encode("1234")).roles("USER").build()
        );
      //UserDetails u2= jdbcUserDetailsManager.loadUserByUsername("user22");
      //if(u2 == null)
        jdbcUserDetailsManager.createUser(
            User.withUsername("user22").password(passwordEncoder.encode("1234")).roles("USER").build()
        );
      //UserDetails u3= jdbcUserDetailsManager.loadUserByUsername("admin2");
      //if(u3 == null)
        jdbcUserDetailsManager.createUser(
            User.withUsername("admin2").password(passwordEncoder.encode("1234")).roles("USER","ADMIN").build()
        );
    };
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
