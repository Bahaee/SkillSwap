package com.example.basics.web;


import com.example.basics.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.basics.repository.UserRepository;

@Controller
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/index")
  public String index(Model model,
      @RequestParam(name = "page",defaultValue = "0") int page,
      @RequestParam(name = "size",defaultValue = "5") int size,
      @RequestParam(name = "keyword",defaultValue = "") String kw
  ){
    Page<User> pageUsers = userRepository.findByNameContains(kw, PageRequest.of(page,size));
    model.addAttribute("listUsers",pageUsers.getContent());
    model.addAttribute("pages",new int[pageUsers.getTotalPages()]);
    model.addAttribute("currentPage",page);
    model.addAttribute("keyword",kw);
    return "users";
  }
}
