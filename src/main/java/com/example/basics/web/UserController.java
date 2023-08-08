package com.example.basics.web;


import com.example.basics.entities.User;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.basics.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/users")
  public List<User> users(){
    return userRepository.findAll();
  }

  @GetMapping("/indexes")
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

  @GetMapping(path="/index")
  public String test(Model model,
      @RequestParam(name = "page", defaultValue = "0") int page,
      @RequestParam(name = "size", defaultValue = "6") int size,
      @RequestParam(name = "keyword", defaultValue = "") String kw){
    Page<User> pageUsers = userRepository.findByNameContains(kw, PageRequest.of(page,size));
    model.addAttribute("listUsers", pageUsers.getContent());
    model.addAttribute("pages", new int[pageUsers.getTotalPages()]);
    model.addAttribute("currentPage", page);
    model.addAttribute("keyword", kw);
    return "users";
  }

  @GetMapping("/delete")
  public String deleteUser(@RequestParam(name = "id") Long id, String keyword, int page){
    userRepository.deleteById(id);
    return "redirect:/index?page="+page+"&keyword="+keyword;
  }

  @GetMapping("/formUser")
  public String formUser(Model model){
    model.addAttribute("user",new User());
    return "formUser";
  }

  @PostMapping("/saveUser")
  public String saveUser(Model model,@Valid User user, BindingResult bindingResult){
    if (bindingResult.hasErrors()) return "formUser";
    userRepository.save(user);
    return "redirect:/formUser";
  }

  @GetMapping("/")
  public String home(){
    return "redirect:/index";
  }

}
