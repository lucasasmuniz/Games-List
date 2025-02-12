package br.com.lucasasmuniz.gameslist.dto;

import org.springframework.beans.BeanUtils;

import br.com.lucasasmuniz.gameslist.model.Game;
import br.com.lucasasmuniz.gameslist.projection.GameMinProjection;
import lombok.Data;

@Data
public class GameMinDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(){}

    public GameMinDTO(Game game){
        BeanUtils.copyProperties(game, this);
    }

    public GameMinDTO(GameMinProjection gameMinProjection){
        BeanUtils.copyProperties(gameMinProjection, this);
    }
}
