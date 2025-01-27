package br.com.lucasasmuniz.gameslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasasmuniz.gameslist.dto.GameListDTO;
import br.com.lucasasmuniz.gameslist.dto.GameMinDTO;
import br.com.lucasasmuniz.gameslist.dto.MoveGameDTO;
import br.com.lucasasmuniz.gameslist.service.GameListService;
import br.com.lucasasmuniz.gameslist.service.GameService;

@RestController
@RequestMapping("/lists")
public class gameListController {
    
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAllList(){
        return gameListService.findAllList();
    }
    @GetMapping("/{id}/game")
    public List<GameMinDTO> searchGameMinByList(@PathVariable Long id){
        return gameService.searchGameMinByList(id);
    }

    @PostMapping("/{id}/replacement")
    public void moveGamePosition(@PathVariable Long id, @RequestBody MoveGameDTO moveGameDTO){
        gameListService.moveGamePosition(id, moveGameDTO.getInitialPosition(), moveGameDTO.getFinalPosition());
    }
}
