package com.steve.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.steve.framework.RedisTemplate;
import com.steve.framework.core.validator.DeleteValidatorGroup;
import com.steve.framework.core.validator.InsertValidatorGroup;
import com.steve.framework.core.validator.UpdateValidatorGroup;
import com.steve.framework.core.web.ApiResult;
import com.steve.framework.core.web.RestStatusCode;
import com.steve.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SteveJobson on 2017/7/13.
 */

@RestController
public class UserControler {

    private static final Logger logger = LoggerFactory.getLogger(UserControler.class);

    @Reference
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ApiResult<User> getUser(
            @RequestParam(value = "userId") Integer userId
    ) {
        User user = null;
        ApiResult<User> result = userService.getUSerById(userId);
        if (RestStatusCode.SUCCESS.code() == result.getStatus()) {
            user = result.getData();
            return new ApiResult(RestStatusCode.SUCCESS.code(), "成功", user);
        } else {
            return new ApiResult(RestStatusCode.INTERNAL_SERVER_ERROR.code(), "调用UserService dubbo接口失败");
        }

    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ApiResult<List<User>> getUsers() {

        RedisTemplate.REDIS_DB_INDEX.set(10);
        redisTemplate.opsForValue().set("demouser", "11111");


        User user = null;
        ApiResult<List<User>> result = userService.listUser();
        if (RestStatusCode.SUCCESS.code() == result.getStatus()) {
            List<User> list = result.getData();
            return new ApiResult(RestStatusCode.SUCCESS.code(), "成功", list);
        } else {
            return new ApiResult(RestStatusCode.INTERNAL_SERVER_ERROR.code(), "调用UserService dubbo接口失败");
        }

    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ApiResult addUSer(
            @RequestBody @Validated(InsertValidatorGroup.class) User user, BindingResult bindingResult
    ) {
        if (bindingResult.hasFieldErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println(fieldError.getDefaultMessage());
            return new ApiResult(RestStatusCode.BAD_REQUEST.code(), fieldError.getDefaultMessage());
        }
        ApiResult<User> result = userService.insertUser(user);
        if (RestStatusCode.SUCCESS.code() == result.getStatus()) {
            user = result.getData();
            return new ApiResult(RestStatusCode.SUCCESS.code(), "成功", user);
        } else {
            return new ApiResult(RestStatusCode.INTERNAL_SERVER_ERROR.code(), "调用UserService dubbo接口失败");
        }
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ApiResult updateUSer(
            @RequestBody @Validated(UpdateValidatorGroup.class) User user, BindingResult bindingResult
    ) {
        if (bindingResult.hasFieldErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println(fieldError.getDefaultMessage());
            return new ApiResult(RestStatusCode.BAD_REQUEST.code(), fieldError.getDefaultMessage());
        }
        ApiResult<User> result = userService.updateUser(user);
        if (RestStatusCode.SUCCESS.code() == result.getStatus()) {
            user = result.getData();
            return new ApiResult(RestStatusCode.SUCCESS.code(), "成功", user);
        } else {
            return new ApiResult(RestStatusCode.INTERNAL_SERVER_ERROR.code(), "调用UserService dubbo接口失败");
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ApiResult deleteUSer(
            @RequestBody @Validated(DeleteValidatorGroup.class) User user, BindingResult bindingResult
    ) {
        if (bindingResult.hasFieldErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println(fieldError.getDefaultMessage());
            return new ApiResult(RestStatusCode.BAD_REQUEST.code(), fieldError.getDefaultMessage());
        }
        ApiResult<User> result = userService.deleteUser(user.getUserId());
        if (RestStatusCode.SUCCESS.code() == result.getStatus()) {
            return new ApiResult(RestStatusCode.SUCCESS.code(), "成功");
        } else {
            return new ApiResult(RestStatusCode.INTERNAL_SERVER_ERROR.code(), "调用UserService dubbo接口失败");
        }
    }

}
