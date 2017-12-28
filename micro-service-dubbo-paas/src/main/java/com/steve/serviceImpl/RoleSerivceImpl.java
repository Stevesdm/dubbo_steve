package com.steve.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.steve.dao.RoleMapper;
import com.steve.model.Role;
import com.steve.model.User;
import com.steve.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.RasterOp;
import java.util.List;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/28 下午4:23
 */
@Service
public class RoleSerivceImpl implements RoleService{


    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> getRoleByUserId(int userId) {

        return roleMapper.getRolesByUserId(userId);
    }
}
