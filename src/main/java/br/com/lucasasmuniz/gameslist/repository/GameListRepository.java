package br.com.lucasasmuniz.gameslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.lucasasmuniz.gameslist.model.GameList;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long>{
    @Modifying
	@Query(nativeQuery = true, 
		value = "UPDATE db_belonging SET position = :newPosition WHERE id_list = :listId AND id_game = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, int newPosition);
}
