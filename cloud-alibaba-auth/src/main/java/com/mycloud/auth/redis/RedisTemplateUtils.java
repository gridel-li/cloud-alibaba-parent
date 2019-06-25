package com.mycloud.auth.redis;


import com.mycloud.auth.utils.SpringContextUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * RedisTemplate操作工具类
 * @Author: hwz
 * @Date: 2018/6/6
 */
public class RedisTemplateUtils {

    private static RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringContextUtils.getBean("redisTemplate");

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @param expire
     */
    public static void set(final String key, final Object value, final long expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.HOURS);
    }

    public static void set(final String key, final Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 读取缓存
     *ValidateCode
     * @param key
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(final String key, Class<T> clazz) {
        return (T) redisTemplate.boundValueOps(key).get();
    }

    /**
     * 读取缓存
     * @param key
     * @return
     */
    public static Object getObj(final String key){
        return redisTemplate.boundValueOps(key).get();
    }

    /**
     * 删除，根据key精确匹配
     *
     * @param key
     */
    public static void del(final String... key) {
        redisTemplate.delete(Arrays.asList(key));
    }

    /**
     * 批量删除，根据key模糊匹配
     *
     * @param pattern
     */
    public static void delpn(final String... pattern) {
        for (String kp : pattern) {
            redisTemplate.delete(redisTemplate.keys(kp + "*"));
        }
    }

    /**
     * key是否存在
     *
     * @param key
     */
    public static boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }
}
