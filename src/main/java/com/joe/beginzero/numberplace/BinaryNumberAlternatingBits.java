package com.joe.beginzero.numberplace;

/**
 * 693. Binary Number with Alternating Bits
 *
 * @author ckh
 * @create 10/8/20 9:38 PM
 */
public class BinaryNumberAlternatingBits {

    public static boolean hasAlternatingBits(int n) {
        int tmp = n ^ (n >> 1);
        return (tmp & (tmp + 1)) == 0;
    }

    public static void main(String[] args) {

    }
}
