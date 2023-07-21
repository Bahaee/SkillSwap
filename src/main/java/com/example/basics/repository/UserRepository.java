package com.example.basics.repository;

import com.example.basics.entities.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Page<User> findByNameContains(String kw, Pageable pageable);
  List<User> findByNameContains(String kw);
  @Query("select u from User u where u.name like :x")
  List<User> search(@Param("x") String kw);

}
