package com.zhk.passwordencryption;

import java.util.Random;

/**
 * @author zhuhk
 * @create 2020-08-25 7:56 上午
 * @Version 1.0
 **/
public class Random16StringSalt implements Isalt{
    private static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    @Override
    public String salt() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < sb.capacity(); i++) {
            sb.append(hex[random.nextInt(16)]);
        }
        return sb.toString();
    }


}
