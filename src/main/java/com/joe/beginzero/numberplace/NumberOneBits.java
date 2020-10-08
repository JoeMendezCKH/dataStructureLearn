package com.joe.beginzero.numberplace;

/**
 * 191. Number of 1 Bits
 *
 * @author ckh
 * @create 10/8/20 4:38 PM
 */
public class NumberOneBits {

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOneBits numberOneBits = new NumberOneBits();
        System.out.println(numberOneBits.hammingWeight(3));
    }

}
