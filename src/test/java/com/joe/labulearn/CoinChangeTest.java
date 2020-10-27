package com.joe.labulearn;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ckh
 * @create 10/27/20 9:19 PM
 */
public class CoinChangeTest {

    @Test
    public void testCoinChange1() {
        int[] coins = new int[]{ 2};
        int amount = 3;
        int ans = new CoinChange().coinMethod3(coins, amount);
        System.out.println(ans);
    }

}