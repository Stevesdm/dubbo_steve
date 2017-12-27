package com.steve.interceptor;

import com.steve.framework.RedisTemplate;
import com.steve.framework.core.constant.CacheKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/27 上午11:17
 */
public class ApiFrequencyInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(ApiFrequencyInterceptor.class);

    @Value("${steve.interface.frequency}")
    private Long interfaceFrequencyLimit;


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("开始进行接口访问频次限制");

        String requestUri = httpServletRequest.getRequestURI();
        String cacheUriKey = getCacheUri(httpServletRequest);

        RedisTemplate.REDIS_DB_INDEX.set(10);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        boolean keyExist = valueOperations.getOperations().hasKey(cacheUriKey);
        if (keyExist){
            RedisTemplate.REDIS_DB_INDEX.set(10);
            valueOperations.increment(cacheUriKey,1);
        }else{
            RedisTemplate.REDIS_DB_INDEX.set(10);
            valueOperations.increment(cacheUriKey,1);
            redisTemplate.expire(cacheUriKey,1, TimeUnit.MINUTES);
        }

        RedisTemplate.REDIS_DB_INDEX.set(10);
        if ( Long.parseLong(redisTemplate.opsForValue().get(cacheUriKey))> interfaceFrequencyLimit){
            httpServletResponse.setContentType("text/html;charset=UTF-8");
            httpServletResponse.getWriter().write("超过接口访问频次限制，请稍后再试");
            httpServletResponse.getWriter().flush();
            return false;
        }else{
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


    private String getCacheUri(HttpServletRequest httpServletRequest){
        String requestUri = httpServletRequest.getRequestURI();
        String cacheUri = String.format(CacheKey.MICRO_SERVICE_INTERFACE_FREQUENCY_LIMIT_URI,requestUri);
        return cacheUri;
    }
}
