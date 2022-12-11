package com.spring;

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

    @GetMapping("/players")
    public List<Player> findAll(){
        return playerService.findAll();
    }

    @GetMapping("/player")
    public Player player(@RequestParam int id){
        return playerService.findById(id);
    }

    @PostMapping("/players")
    public Player save(@RequestBody Player player){
        return playerService.save(player);
    }

    @PutMapping("/players")
    public Player update(@RequestBody Player player){
        return playerService.save(player);
    }

    @DeleteMapping("/players/{id}")
    public Player delete(@PathVariable("id")int id){
        Player player = playerService.findById(id);
        if(player == null){
            throw new PlayerException("player not found with that id");
        }

        playerService.Delete(id);
        return player;
    }

}
