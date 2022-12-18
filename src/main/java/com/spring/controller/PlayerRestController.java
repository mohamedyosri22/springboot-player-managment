package com.spring.controller;

import com.spring.exception.PlayerException;
import com.spring.model.Player;
import com.spring.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerRestController {
    @Autowired
    private PlayerService playerService;


    // http://localhost:9090/api/players
    @GetMapping("/players")
    public List<Player> findAll(){
        return playerService.findAll();
    }



    // http://localhost:9090/api/player?id=1
    @GetMapping("/player")
    public Player getPlayer(@RequestParam int id){
        Player player = playerService.findById(id);
        if(player == null){
            throw new PlayerException("player not found with that id");
        }
        return player;
    }



    // http://localhost:9090/api/players
    @PostMapping("/players")
    public Player save(@RequestBody Player player){
        return playerService.save(player);
    }



    // http://localhost:9090/api/players
    @PutMapping("/players")
    public Player update(@RequestBody Player player){
        return playerService.save(player);
    }



    // http://localhost:9090/api/players/1
    @DeleteMapping("/players/{id}")
    public Player delete(@PathVariable("id")int id){
        Player player = playerService.findById(id);
        if(player == null){
            throw new PlayerException("player not found with that id");
        }

        playerService.delete(id);
        return player;
    }



    // http://localhost:9090/api/playersSearch?name=k
    @GetMapping("/players-search")
    public List<Player> Search(@RequestParam String name){
       return playerService.findByNameContaining(name);
    }

}
