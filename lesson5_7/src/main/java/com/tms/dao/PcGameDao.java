package com.tms.dao;

import com.tms.model.PcGame;

import java.util.List;

public interface PcGameDao {
    List<PcGame> findAllPcGames();
    void addPcGame(PcGame pcGame);
    void deletePcGameById(Integer pcGameId);
}
