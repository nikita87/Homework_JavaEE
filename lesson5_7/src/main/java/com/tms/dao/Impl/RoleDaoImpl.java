package com.tms.dao.Impl;

import com.tms.dao.RoleDao;
import com.tms.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SQL_USER_ROLES = "SELECT roles.id, roles.name FROM userdata " +
            "LEFT OUTER JOIN user_roles " +
            "ON userdata.id = user_roles.user_id " +
            "LEFT OUTER JOIN roles " +
            "ON user_roles.role_id = roles.id WHERE userdata.id = ?";
    @Override
    public List<Role> findUserRoles(Long userId) {
        return jdbcTemplate.query(SQL_USER_ROLES, new RoleMapper(), userId);
    }
}
