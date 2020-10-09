package com.joe.beginzero.numberplace;

import org.omg.CORBA.INTERNAL;

/**
 * 393. UTF-8 Validation
 *
 * @author ckh
 * @create 10/9/20 4:27 PM
 */
public class UTF8Validation {

    public static boolean validUtf8(int[] data) {
        int count = 0;
        for (int num : data) {
            if (count > 0) {
                if (num >> 6 != 0b10) {
                    return false;
                }
                count--;
            }
            // num如果为负数时，前面很多位都为 1， -1：11111111 超出了utf-8 4个字节的要求
            else if (num >> 7 == 0) {
                // 只有一个字节
                count = 0;
            } else if (num >> 5 == 0b110) {
                // 在该num后还要有 1 个字节： 0b10xxxxx
                count = 1;
            } else if (num >> 4 == 0b1110) {
                // 在该num后还要有 2 个字节： 0b10xxxxx
                count = 2;
            } else if (num >> 3 == 0b11110) {
                // 在该num后还要有 3 个字节： 0b10xxxxx
                count = 3;
            } else {
                return false;
            }
        }
        return count == 0;

    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(193));
        System.out.println(validUtf8(new int[]{193, 1}));
    }

}
