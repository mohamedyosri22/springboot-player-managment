package com.spring.service;

import com.spring.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PlayerService {
    public List<Player> findAll();

    public Player findById(int id);

    public int Delete(int id);

    public Player save(Player player);
}
