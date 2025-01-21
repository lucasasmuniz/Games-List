package br.com.lucasasmuniz.gameslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucasasmuniz.gameslist.dto.GameMinDTO;
import br.com.lucasasmuniz.gameslist.model.Game;
import br.com.lucasasmuniz.gameslist.repository.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository GameRepository;
    
    public List<GameMinDTO> findAll(){
        return GameRepository.findAll().stream().map(x -> new GameMinDTO(x)).toList();
    }
}
