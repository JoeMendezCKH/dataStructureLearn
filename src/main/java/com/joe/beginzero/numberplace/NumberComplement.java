package com.joe.beginzero.numberplace;

/**
 * 476. Number Complement
 * 给你一个十进制数 N，返回其二进制表示的反码所对应的十进制整数
 *
 * @author ckh
 * @create 10/8/20 4:41 PM
 */
public class NumberComplement {

    public int findComplement(int num) {
        // 题目要求 num >= 0
        if (num < 0) {
            return 0;
        }


        // ~num，包括符号位 也取反了
        int temp = ~num;

        //  hashmap 中的方法，将 num 从最高位为 1 后全部置为 1
        num |= num >>> 1;
        num |= num >>> 2;
        num |= num >>> 4;
        num |= num >>> 8;
        num |= num >>> 16;

        // 只取原来长度
        return temp & num;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(~5));

        NumberComplement complement = new NumberComplement();
        System.out.println(complement.findComplement(5));
        System.out.println(~5);
    }
}
