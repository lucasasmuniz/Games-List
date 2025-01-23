package br.com.lucasasmuniz.gameslist.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@Data
@EqualsAndHashCode(of = { "game", "gameList" })
public class BelongingPK {
    @ManyToOne
    @JoinColumn(name = "id_game")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "id_list")
    private GameList gameList;


}
