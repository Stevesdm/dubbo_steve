package com.steve.dao;

import com.steve.common.BaseMapper;
import com.steve.model.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {


    public List<Role> getRolesByUserId(int userId);

}