package com.spring.dao;

import com.spring.model.Player;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDaoImpl implements PlayerDao {

    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Player> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Player> query = session.createQuery("from Player",Player.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public Player findById(int id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Player.class,id);
    }

    @Override
    @Transactional
    public int Delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Player where id = "+id);

        return query.executeUpdate();
    }

    @Override
    @Transactional
    public Player save(Player player) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(player);
        return player;
    }
}
