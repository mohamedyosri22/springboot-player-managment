package com.spring.controller;

import com.spring.model.Player;
import com.spring.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;


// http://localhost:9090/
@Controller
@RequestMapping("/main")
//http://localhost:9090/main
public class MainController {
    @Autowired
    private PlayerService playerService;

    // http://localhost:9090/main/players  ==> GET
    @GetMapping("/players")
    public String getAll(Model model){
        List<Player> players = playerService.findAll();
        model.addAttribute("players",players);
        model.addAttribute("currentDate",new Date());
        return "home";
    }


    // http://localhost:9090/main/player-form  ==> GET
    @GetMapping("/player-form")
    public String playerForm(Model model){
        model.addAttribute("player",new Player());
        return "playerform";
    }

    @PostMapping("/save-player")
    public String savePlayer(@ModelAttribute("player")Player player){
        playerService.save(player);

        return "redirect:/main/players";
    }


}
