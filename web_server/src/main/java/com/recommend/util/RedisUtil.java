package com.recommend.util;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 操作redis的工具类
 * @Author XMuser
 * @Date 2021-06-09 16:40
 */
@Repository
public class RedisUtil {

    private final RedisTemplate redisTemplate;

    public RedisUtil(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
    }

    /**
     * 添加数据（永久的）
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 添加数据，有时效，单位为：分钟
     *
     * @param key     键
     * @param value   值
     * @param timeout 时间长度
     */
    public void set(String key, Object value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MINUTES);
    }

    /**
     * 删除数据，并判断是否删除成功
     *
     * @param key 键
     * @return boolean
     */
    public boolean delete(String key) {
        redisTemplate.delete(key);
        return !redisTemplate.hasKey(key);
    }

    /**
     * 获取数据
     *
     * @param key 键
     * @return {@link Object}
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}

