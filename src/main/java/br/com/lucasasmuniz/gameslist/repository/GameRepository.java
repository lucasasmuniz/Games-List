package br.com.lucasasmuniz.gameslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucasasmuniz.gameslist.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

    
}