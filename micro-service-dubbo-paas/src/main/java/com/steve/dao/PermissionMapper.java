package com.steve.dao;

import com.steve.common.BaseMapper;
import com.steve.model.Permission;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> getPermissionsByUserId(int userId);
}