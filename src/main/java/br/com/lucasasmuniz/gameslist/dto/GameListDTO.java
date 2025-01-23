package br.com.lucasasmuniz.gameslist.dto;

import org.springframework.beans.BeanUtils;

import br.com.lucasasmuniz.gameslist.model.GameList;
import lombok.Data;

@Data
public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO(GameList gameList){
        BeanUtils.copyProperties(gameList, this);
    }
}
