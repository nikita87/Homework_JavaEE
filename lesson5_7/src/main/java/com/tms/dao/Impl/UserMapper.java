package com.tms.dao.Impl;

import com.tms.model.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return User.builder()
                .id(resultSet.getInt("id"))
                .username(resultSet.getString("username"))
                .password(resultSet.getString("pass"))
                .name(resultSet.getString("name"))
                .surname(resultSet.getString("surname"))
                .build();
    }
}
