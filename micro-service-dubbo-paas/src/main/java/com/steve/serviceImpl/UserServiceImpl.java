package com.steve.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.steve.dao.UserMapper;
import com.steve.framework.core.web.ApiResult;
import com.steve.framework.core.web.RestStatusCode;
import com.steve.model.User;
import com.steve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by SteveJobson on 2017/7/13.
 */

/**
 * 根据服务提供者的服务类型设置集群容错机制
 */
@Component
@Service(version = "1.0.0", interfaceClass = UserService.class, timeout = 5000, retries = 2)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ApiResult<User> getUSerById(int userId) throws InterruptedException {
        User user = userMapper.selectByPrimaryKey(userId);
        return new ApiResult<User>(RestStatusCode.SUCCESS.code(),"成功",user);
    }
}
