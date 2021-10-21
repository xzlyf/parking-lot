package com.xz.parking.utils;

import java.util.Random;

/**
 * @Author: xz
 * @Date: 2021/10/20
 */
public class RandomUtils {
    public static String randomNumber(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int temp;
        for (int i = 0; i < length; i++) {
            temp = random.nextInt(10);
            if (i == 0 && temp == 0) {
                //确保首位不为0
                i--;
                continue;
            }
            sb.append(temp);
        }
        return sb.toString();
    }

    public static String randomString(int length) {
        String[] a = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(a[random.nextInt(a.length)].toUpperCase());
                continue;
            }
            sb.append(a[random.nextInt(a.length)]);
        }
        return sb.toString();
    }
}
