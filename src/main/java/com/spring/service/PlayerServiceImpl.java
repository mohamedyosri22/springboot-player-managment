package com.spring.service;


import com.spring.dao.PlayerRepo;
import com.spring.model.Player;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public List<Player> findAll() {
        return playerRepo.findAll();
    }

    @Override
    public Player findById(int id) {
        return playerRepo.findById(id).get();
    }

    @Override
    public void delete(int id) {
        playerRepo.deleteById(id);
    }

    @Override
    public Player save(Player player) {
        return playerRepo.save(player);
    }

    @Override
    public List<Player> findByNameContaining(String name){
        return playerRepo.findByNameContaining(name);
    }

}
