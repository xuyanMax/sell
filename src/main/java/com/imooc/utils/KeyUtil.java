package com.imooc.utils;

import java.util.Random;

/**
 * @Author: xyx
 * @Date: 2018-12-02 23:51
 * @Version 1.0
 * 时间+随机数
 */
public class KeyUtil {

    public static synchronized String genUniqueKey() {
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;//6位

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
