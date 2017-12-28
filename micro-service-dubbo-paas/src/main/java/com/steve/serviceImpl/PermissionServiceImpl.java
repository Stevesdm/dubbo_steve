package com.steve.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.steve.dao.PermissionMapper;
import com.steve.model.Permission;
import com.steve.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/28 下午2:48
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public List<Permission> getPermissionsByUserId(int userId) {
        return permissionMapper.getPermissionsByUserId(userId);
    }
}
