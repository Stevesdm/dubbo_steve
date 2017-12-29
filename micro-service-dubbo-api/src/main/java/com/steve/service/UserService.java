package com.steve.service;

import com.steve.framework.core.web.ApiResult;
import com.steve.model.User;

import java.util.List;

/**
 * Created by SteveJobson on 2017/7/13.
 */
public interface UserService {


    ApiResult<User> getUSerById(int userId);

    ApiResult<List<User>> listUser();

    ApiResult<User> insertUser(User user);

    ApiResult<User> updateUser(User user);

    ApiResult deleteUser(int userId);


    User getUserByName(String username);


}
