package com.joe.beginzero.strings;

/**
 * 434. Number of Segments in a String
 *
 * @author ckh
 * @create 14/08/2020 10:16
 */
public class NumberSegments {
    /**
     * using string api
     */
    public static int countSegments1(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }

    public static int countSegments2(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            // the position is begin or before position is blank
            // and the current position is not blank, so this position is begin of a word
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }
        return segmentCount;
    }

    public static void main(String[] args) {

    }
}
