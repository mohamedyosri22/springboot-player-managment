package com.spring.dao;

import com.spring.model.Player;

import java.util.List;

public interface PlayerDao {
    public List<Player> findAll();

    public Player findById(int id);

    public int Delete(int id);

    public Player save(Player player);
}
