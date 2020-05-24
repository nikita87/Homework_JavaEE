package com.tms.dao;

import com.tms.model.User;

import java.util.List;

public interface UserDao {
    User findByUsername (String username);
    List<User> findAllUsers();
    void addUser(User user);
    void deleteUser(Integer userId);
}
