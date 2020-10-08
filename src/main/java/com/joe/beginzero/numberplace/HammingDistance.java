package com.joe.beginzero.numberplace;

/**
 * 461. Hamming Distance
 *
 * @author ckh
 * @create 10/8/20 5:18 PM
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int count = 0, m, n;
        for (int i = 0; i < 32; i++) {
            m = x & 1;
            n = y & 1;
            x >>= 1;
            y >>= 1;
            if (m != n) {
                count++;
            }
        }
        return count;
    }
}
