package com.joe.beginzero.numberplace;

/**
 * 190. Reverse Bits
 *
 * @author ckh
 * @create 10/8/20 4:09 PM
 */
public class ReverseBits {

    /**
     *  you need treat n as an unsigned value
     */
    public int reverseBits(int n) {
        int res = 0;
        // 处理固定的32位长度，保证前置 0 的处理
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(-3 << 1));
    }
}
