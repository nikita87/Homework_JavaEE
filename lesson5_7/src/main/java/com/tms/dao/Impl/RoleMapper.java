package com.tms.dao.Impl;

import com.tms.model.Role;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet resultSet, int i) throws SQLException {
        return Role.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .build();
    }
}
