package com.spring.dao;

import com.spring.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface PlayerRepo extends JpaRepository<Player,Integer> {
    Player findByName(String name);

    List<Player> findByNameContaining(String name);


}

// Get  ====> http://localhost:9090/restapi/players
// Get  ====> http://localhost:9090/restapi/players/id
// Post  ====> http://localhost:9090/restapi/players
// Put  ====> http://localhost:9090/restapi/players
// Delete  ====> http://localhost:9090/restapi/players/id
// Get  ====> http://localhost:9090/restapi/players/search/findByName?name=mohamed

// Get  ====> http://localhost:9090/restapi/players/search/findByNameContaining?name=mohamed


