package com.steve.service;

import com.steve.model.Role;

import java.util.List;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/28 下午4:22
 */
public interface RoleService {

    List<Role> getRoleByUserId(int userId);

}
