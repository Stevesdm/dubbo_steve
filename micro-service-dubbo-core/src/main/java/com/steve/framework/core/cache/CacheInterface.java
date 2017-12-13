package com.steve.framework.core.cache;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/11 下午10:25
 */
public interface CacheInterface {

    /**
     * 实现接口在应用启动时加载热数据
     *
     * @return
     */

    boolean loadCache();

    boolean deleteCache();

}
