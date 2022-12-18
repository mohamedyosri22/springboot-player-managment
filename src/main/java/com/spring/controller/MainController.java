package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// http://localhost:9090/
@Controller
@RequestMapping("/main")
//http://localhost:9090/main
public class MainController {

    // http://localhost:9090/main/profile
    @GetMapping("/profile")
    public String test(Model model){
        model.addAttribute("name","mohamed yosri");
        return "home";
    }
}
