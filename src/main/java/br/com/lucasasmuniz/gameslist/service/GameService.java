package br.com.lucasasmuniz.gameslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucasasmuniz.gameslist.dto.GameDTO;
import br.com.lucasasmuniz.gameslist.dto.GameMinDTO;
import br.com.lucasasmuniz.gameslist.model.Game;
import br.com.lucasasmuniz.gameslist.repository.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        return gameRepository.findAll().stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findGameById(Long id){
        // FAZER TESTE COM ID DESCONHECIDO PRA VER UMA COISA
        Game game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> searchGameMinByList(Long id){
        return gameRepository.searchGamesByList(id).stream().map(x -> new GameMinDTO(x)).toList();
    }

}
