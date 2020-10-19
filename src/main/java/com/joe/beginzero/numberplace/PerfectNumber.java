package com.joe.beginzero.numberplace;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 507. Perfect Number
 *
 * @author ckh
 * @create 10/19/20 8:57 AM
 */
public class PerfectNumber {

    public static boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int res = 1;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                res += i;
                res += num / i;
            }
        }
        return num == res;

    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(8128));
    }
}
