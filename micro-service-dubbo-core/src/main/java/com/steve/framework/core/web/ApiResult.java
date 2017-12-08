package com.steve.framework.core.web;

import com.sun.xml.internal.rngom.ast.builder.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;

import java.io.Serializable;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/7 下午6:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> implements Serializable {

    /**
     * 使用FastJson默认不序列化值为null的属性
     */


    public static final String SUCCESS_DESCRIPTION = "成功";

    public static final int SUCCESS_RESULT = 0;

    public static final int FAIL_RESULT = -1;

    //返回状态码
    private int statusCode;
    //返回描述
    private String desc;
    //成功返回数据
    private T data;

    //失败的构造方法
    public ApiResult(int statusCode, String desc) {
        this.statusCode = statusCode;
        this.desc = desc;
    }

}
