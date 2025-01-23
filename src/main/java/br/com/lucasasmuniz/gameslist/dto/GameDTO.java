package br.com.lucasasmuniz.gameslist.dto;

import org.springframework.beans.BeanUtils;

import br.com.lucasasmuniz.gameslist.model.Game;
import lombok.Data;

@Data
public class GameDTO {
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO(Game game){
        BeanUtils.copyProperties(game, this);
    }
}
