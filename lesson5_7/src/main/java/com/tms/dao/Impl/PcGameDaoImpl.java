package com.tms.dao.Impl;

import com.tms.dao.PcGameDao;
import com.tms.model.PcGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PcGameDaoImpl implements PcGameDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SQL_SELECT_ALL_PC_GAMES = "SELECT * FROM pcgame";

    @Override
    public List<PcGame> findAllPcGames() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PC_GAMES, new PcGameMapper());
    }

    @Override
    public void addPcGame(PcGame pcGame) {
        jdbcTemplate.update("INSERT INTO pcgame (title, genre, publisher) VALUES (?, ?, ?)", pcGame.getTitle(), pcGame.getGenre(), pcGame.getPublisher());
    }

    @Override
public void deletePcGameById(Integer pcGameId) {
    jdbcTemplate.update("DELETE FROM pcgame WHERE id = ?", pcGameId);
}
}
