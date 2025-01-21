package br.com.lucasasmuniz.gameslist.dto;

import br.com.lucasasmuniz.gameslist.model.Game;
import lombok.Getter;

@Getter
public class GameMinDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(){}

    public GameMinDTO(Game game){
        this.id = game.getId();
        this.title = game.getTitle();
        this.year = game.getYear();
        this.imgUrl = game.getImgUrl();
        this.shortDescription = game.getShortDescription();
    }
}
