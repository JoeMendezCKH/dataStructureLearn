package com.joe.datastructure.demo;

import org.junit.Test;

/**
 * @author ckh
 * @create 10/8/20 2:51 PM
 */
public class MathTest {

    @Test
    public void testMath() {
        int num = 9;
        for (int i = 0; i < 1000; i++) {
            int res = (i + 2) * 11 / 10;
            System.out.println("i: " + i + " -> " + res);
        }

    }
}
