package com.tms.dao.Impl;

import com.tms.dao.UserDao;
import com.tms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private  final String SQL_SELECT_USER_BY_USERNAME = "SELECT e.id, e.username, e.pass, e.name, e.surname, roles.name as role" +
            " FROM userdata e " +
            "LEFT OUTER JOIN user_roles " +
            "ON e.id=user_roles.user_id " +
            "LEFT OUTER JOIN roles " +
            "ON user_roles.role_id = roles.id WHERE e.username = ?";

    private final String SQL_SELECT_ALL_USERS = "SELECT * FROM userdata";

    @Override
    public User findByUsername(String username) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_USERNAME, new UserMapper(), username);
    }

    @Override
    public List<User> findAllUsers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, new UserMapper());
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO userdata (username, pass, name, surname) VALUES (?, ?, ?, ?)",
                user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getName(), user.getSurname());
    }

    @Override
    public void deleteUser(Integer userId) {
        jdbcTemplate.update("DELETE FROM userdata WHERE id = ?", userId);
    }
}
