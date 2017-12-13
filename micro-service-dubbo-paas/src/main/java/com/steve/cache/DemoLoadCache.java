package com.steve.cache;

import com.steve.framework.core.cache.CacheInterface;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/13 下午6:01
 */
@Service
public class DemoLoadCache implements CacheInterface {


    //实现CacheInterface接口，实现loadCache方法 ，加载数据，使用redis存储  TODO
    @Override
    public boolean loadCache() {

        System.out.println("1111");
        return true;
    }

    @Override
    public boolean deleteCache() {
        return false;
    }
}
