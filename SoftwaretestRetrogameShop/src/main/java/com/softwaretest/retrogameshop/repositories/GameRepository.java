package com.softwaretest.retrogameshop.repositories;

import com.softwaretest.retrogameshop.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    public List<Game> findAllByGenreAndTitleAndReleaseYear(String genre, String title, Integer releaseYear);
    public List<Game> findAll();

    @Query(value = "select * from game g join purchases p on (g.id = p.game_id) " +
            "join customer c on (p.customer_id = c.id)",
            nativeQuery = true)
    public List<Game> findGamesWithPurchaser();
}
