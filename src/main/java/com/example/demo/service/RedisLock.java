package com.example.demo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;
    /**
     * 加锁
     * @Param key,value
     */

    public boolean lock(String key,String value){
        if(redisTemplate.opsForValue().setIfAbsent(key, value)){
            return true;
        }
        String currentValue = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue)<System.currentTimeMillis()){
            String oldValue = redisTemplate.opsForValue().getAndSet(key,value);
            if(!StringUtils.isEmpty(oldValue)
                    && oldValue.equals(currentValue)){
                return true;
            }
        }
        return false;
    }

    public void unlock(String key,String value){
        try{
            String currentValue = redisTemplate.opsForValue().get(key);
            if(value.equals(currentValue)){
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.info("redis锁解锁异常");
        }

    }

}
