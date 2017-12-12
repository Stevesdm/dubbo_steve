package com.steve.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.steve.framework.core.web.ApiResult;
import com.steve.framework.core.web.RestStatusCode;
import com.steve.model.User;
import com.steve.service.UserService;
import com.steve.validator.InsertValidatorGroup;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by SteveJobson on 2017/7/13.
 */

@RestController
public class UserControler {

    @Reference(version = "1.0.0", interfaceClass = UserService.class)
    public UserService userService;


    @RequestMapping(value = "/")
    public ApiResult<User> getPersonInfo(
            @RequestParam(value = "userId") Integer userId
    ) throws InterruptedException {
        User user = null;
        ApiResult<User> result = userService.getUSerById(userId);
        if (RestStatusCode.SUCCESS.code() == result.getStatus()) {
            user = result.getData();
            return new ApiResult<User>(RestStatusCode.SUCCESS.code(),"成功",user);
        }else {
            return new ApiResult<User>(RestStatusCode.INTERNAL_SERVER_ERROR.code(),"调用UserService dubbo接口失败");
        }


    }

    public ApiResult addUSer(
            @RequestBody @Validated(InsertValidatorGroup.class) User user, BindingResult bindingResult
    ){
        if (bindingResult.hasFieldErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            //TODO
            System.out.println(fieldError.getDefaultMessage());
        }
        //TODO

        return null;
    }

}
