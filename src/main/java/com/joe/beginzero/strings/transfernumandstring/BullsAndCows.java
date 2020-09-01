package com.joe.beginzero.strings.transfernumandstring;


/**
 * 299. Bulls and Cows
 *
 * @author ckh
 * @create 8/28/20 8:51 AM
 */
public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int[] mapS = new int[10];
        int[] mapG = new int[10];
        // traverse the string, compare the letter
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                mapS[secret.charAt(i) - '0']++;
                mapG[guess.charAt(i) - '0']++;
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(mapS[i], mapG[i]);
        }
        return bulls + "bulls" + cows + "cows";
    }

    public static void main(String[] args) {
        String s = "1807";
        String g = "7810";
        System.out.println(getHint(s, g));
    }
}
