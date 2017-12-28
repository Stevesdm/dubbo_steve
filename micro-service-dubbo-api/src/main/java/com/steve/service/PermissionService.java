package com.steve.service;


import com.steve.model.Permission;

import java.util.List;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/28 下午2:43
 */
public interface PermissionService {


    List<Permission> getPermissionsByUserId(int userId);


}
