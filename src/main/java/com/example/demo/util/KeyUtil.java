package com.example.demo.util;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成唯一主键，时间+随机数
     * @return
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        System.currentTimeMillis();
        Integer number = random.nextInt(90000)+10000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
