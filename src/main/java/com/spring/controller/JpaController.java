package com.spring.controller;


import com.spring.dao.PlayerRepo;
import com.spring.exception.PlayerException;
import com.spring.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    private PlayerRepo playerRepo;

    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return playerRepo.findAll();
    }

    @GetMapping("/player")
    public Player getPlayer(@RequestParam int id){
        Player player = playerRepo.findById(id).get();
        if(player == null){
            throw new PlayerException("player not found with that id");
        }
        return player;
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return playerRepo.save(player);
    }

    @PutMapping("/players")
    public Player updatePlayer(@RequestBody Player player){
       return playerRepo.save(player);
    }

    @DeleteMapping("/players")
    public void deletePlayer(@RequestParam int id){

        if(playerRepo.findById(id) == null){
            throw new PlayerException("no player found with that id");
        }

        playerRepo.deleteById(id);
    }


}
