package com.gamestore.GameStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamestore.GameStore.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

	public List <Game> findAllByNameContainingIgnoreCase (String name);
}
