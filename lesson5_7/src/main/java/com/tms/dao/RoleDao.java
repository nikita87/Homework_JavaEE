package com.tms.dao;

import com.tms.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findUserRoles(Long userId);
}
