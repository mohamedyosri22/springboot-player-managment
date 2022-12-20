package com.spring.service;

import com.spring.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PlayerService {

    public List<Player> orderedPlayers();
    public List<Player> findAll();

    public Player findById(int id);

    public void delete(int id);

    public Player save(Player player);

    public List<Player> findByNameContaining(String name);

}
