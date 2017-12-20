package com.steve.framework.core.web;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ApiResult：rest接口返回对象
 * @Author: stevejobson
 * @CreateDate: 2017/12/7 下午6:08
 */
@Data
public class ApiResult<T> implements Serializable {

    /**
     * 使用FastJson默认不序列化值为null的属性
     */

    private int status;

    private String desc;

    private T data;

    public ApiResult(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public ApiResult(int status, String desc, T data) {
        this.status = status;
        this.desc = desc;
        this.data = data;
    }

}
