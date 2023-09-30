package com.example.basics.web;

import java.util.Map;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestApi {

  @GetMapping("/dataTest")
  @PreAuthorize("hasAuthority('SCOPE_USER')")
  public Map<String, Object> dataTest(Authentication authentication){
    return Map.of(
        "Message","Data Test",
        "Username", authentication.getName(),
        "Authorities", authentication.getAuthorities()
    );
  }

  @PostMapping("/saveData")
  @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
  public Map<String,String> saveData(String data){
    return Map.of(
      "Data", data
    );
  }
}
