package demo.controllers;

import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;

@Controller
@RequestMapping()
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/logout1")
    public String getlogoutForm(Model model,Principal principal){
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "logout";
    }

    @GetMapping("/user")//МЕТОД ЮЗЕРА, А ОСТАЛЬНЫЕ ПЕРЕНЕСЕМ В AdminController
    public String getUser(Model model,Principal principal){//@PathVariable("id") long id){
        model.addAttribute("user", userService.findByUsername(principal.getName()));
       // model.addAttribute("user",userService.findById(id));
        return "show";
    }

}
