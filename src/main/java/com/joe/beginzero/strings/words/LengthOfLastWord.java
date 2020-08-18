package com.joe.beginzero.strings.words;

/**
 * 58. Length of Last Word
 *
  * @author ckh
 * @create 15/08/2020 12:00
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord1("h "));

    }

    public static int method2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }

    public static int lengthOfLastWord1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }


        StringBuilder reverse = new StringBuilder(s.trim()).reverse();

        char[] charArray = reverse.toString().toCharArray();
        int count = 0;
        for (char c : charArray) {
            if (Character.isLetter(c)) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }
}
