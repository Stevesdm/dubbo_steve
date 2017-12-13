package com.steve.framework.core.web;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/11 下午10:03
 */
public enum RestStatusCode {


    /**
     * 成功
     */
    SUCCESS(200),

    /**
     * 参数错误
     */
    BAD_REQUEST(400),

    /**
     * 资源不存在
     */
    NOT_FOUND(404),

    /**
     * 系统错误
     */
    INTERNAL_SERVER_ERROR(500),

    /**
     * 当前无法处理请求
     */
    SERVICE_UNAVAILABLE(503);

    private int code;

    RestStatusCode(int code) {
        this.code = code;
    }

    public int code() {
        return this.code;
    }

}
