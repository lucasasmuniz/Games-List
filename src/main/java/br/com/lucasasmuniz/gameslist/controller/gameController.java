package br.com.lucasasmuniz.gameslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasasmuniz.gameslist.service.GameService;
import br.com.lucasasmuniz.gameslist.dto.GameMinDTO;

@RestController
@RequestMapping("/game")
public class gameController {
    
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAllGames(){
        return gameService.findAll();
    } 
}
