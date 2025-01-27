package br.com.lucasasmuniz.gameslist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucasasmuniz.gameslist.dto.GameListDTO;
import br.com.lucasasmuniz.gameslist.dto.GameMinDTO;
import br.com.lucasasmuniz.gameslist.repository.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameService gameService;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllList(){
        return gameListRepository.findAll().stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void moveGamePosition(Long idList,int initialPosition, int finalPosition){
        List<GameMinDTO> list = new ArrayList<>(gameService.searchGameMinByList(idList));
        GameMinDTO obj = list.remove(initialPosition);
        list.add(finalPosition, obj);
        int positionMin = initialPosition < finalPosition ? initialPosition : finalPosition;
        int positionMax = initialPosition < finalPosition ? finalPosition : initialPosition;

        for(int i = positionMin; i <= positionMax ; i++){
            gameListRepository.updateBelongingPosition(idList, list.get(i).getId(), i);
        }
    }
}
