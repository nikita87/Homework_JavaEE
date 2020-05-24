package com.tms.dao.Impl;

import com.tms.model.PcGame;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PcGameMapper implements RowMapper<PcGame> {

    @Override
    public PcGame mapRow(ResultSet resultSet, int i) throws SQLException {
        return PcGame.builder()
                .id(resultSet.getInt("id"))
                .title(resultSet.getString("title"))
                .genre(resultSet.getString("genre"))
                .publisher(resultSet.getString("publisher"))
                .build();
    }
}
