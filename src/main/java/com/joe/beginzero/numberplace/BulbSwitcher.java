package com.joe.beginzero.numberplace;

/**
 * 319. Bulb Switcher
 *
 * @author ckh
 * @create 10/12/20 11:01 AM
 */
public class BulbSwitcher {
    /**
     * 数学问题 >_<
     * https://leetcode-cn.com/problems/bulb-switcher/solution/wei-shi-yao-ping-fang-shu-yi-ding-shi-liang-zhao-d/
     */
    public static int bulbSwitch(int n) {
       return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(8));
    }
}
