package com.joe.beginzero.strings.countwords;

import javax.swing.plaf.multi.MultiViewportUI;

/**
 * 657. Robot Return to Origin
 *
 * @author ckh
 * @create 8/24/2020 11:23 AM
 */
public class RobotReturnOrigin {
    public static boolean judgeCircle1(String moves) {
        int length;
        if (moves == null || (length = moves.length()) == 0) {
            // don't move
            return true;
        }
        if (length % 2 != 0) {
            return false;
        }
        // distributions[0]: U/D distributions[1]:L/R
        int[] distributions = new int[2];
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                distributions[0]++;
            } else if (c == 'D') {
                distributions[0]--;
            } else if (c == 'L') {
                distributions[1]++;
            } else if (c == 'R') {
                distributions[1]--;
            }
        }
        return distributions[0] == 0 && distributions[1] == 0;
    }

    public static boolean judgeCircle2(String moves) {
        int[] letters = new int[26 + 'A'];
        for (char c : moves.toCharArray()) {
            letters[c]++;
        }
        return letters['U'] == letters['D'] && letters['L'] == letters['R'];
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle1("LLDDUURR"));

    }
}
