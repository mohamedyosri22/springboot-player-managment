package com.spring.service;


import com.spring.model.Player;
import com.spring.dao.PlayerDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDao playerDao;

    @Override
    public List<Player> findAll() {
        return playerDao.findAll();
    }

    @Override
    public Player findById(int id) {
        return playerDao.findById(id);
    }

    @Override
    public int Delete(int id) {
        return playerDao.Delete(id);
    }

    @Override
    public Player save(Player player) {
        return playerDao.save(player);
    }
}
