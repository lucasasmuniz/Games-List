package br.com.lucasasmuniz.gameslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucasasmuniz.gameslist.dto.GameListDTO;
import br.com.lucasasmuniz.gameslist.repository.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllList(){
        return gameListRepository.findAll().stream().map(x -> new GameListDTO(x)).toList();
    }
}
