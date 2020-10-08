package com.joe.beginzero.numberplace;

/**
 * @author ckh
 * @create 10/8/20 4:41 PM
 */
public class NumberComplement {

    public int findComplement(int num) {
        if (num < 0) {
            return 0;
        }
        int temp = ~num;

        //  hashmap 中的方法，将 num 从最高位为 1 后全部置为 1
        num |= num >>> 1;
        num |= num >>> 2;
        num |= num >>> 4;
        num |= num >>> 8;
        num |= num >>> 16;

        return temp & num;
    }

    public static void main(String[] args) {
        NumberComplement complement = new NumberComplement();
        System.out.println(complement.findComplement(5));
    }
}
