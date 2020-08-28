package com.joe.beginzero.strings.transfernumandstring;

import java.util.Arrays;

/**
 * 299. Bulls and Cows
 *
 * @author ckh
 * @create 8/28/20 8:51 AM
 */
public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int A = 0;
        int[] mapS = new int[10];
        int[] mapG = new int[10];
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                mapS[secret.charAt(i) - '0']++;
                mapG[guess.charAt(i) - '0']++;
            }
        }
        int B = 0;
        for (int i = 0; i < 10; i++) {
            B += Math.min(mapS[i], mapG[i]);
        }
        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        String s = "1807";
        String g = "7810";
        System.out.println(getHint(s, g));
    }
}
