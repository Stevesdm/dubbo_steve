package com.steve.service;

import com.steve.framework.core.web.ApiResult;
import com.steve.model.User;

/**
 * Created by SteveJobson on 2017/7/13.
 */
public interface UserService {

    ApiResult<User> getUSerById(int userId) throws InterruptedException;

}
