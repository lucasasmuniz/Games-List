package br.com.lucasasmuniz.gameslist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.lucasasmuniz.gameslist.model.Game;
import br.com.lucasasmuniz.gameslist.projection.GameMinProjection;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

    @Query(nativeQuery = true, value = """
            SELECT game.id, game.title, game.game_year, game.img_url, game.short_description, belonging.position
            FROM db_game game
            inner join db_belonging belonging on belonging.id_game = game.id
            where belonging.id_list = :idList
            order by belonging.position
            """)
    public List<GameMinProjection> searchGamesByList(Long idList);
}