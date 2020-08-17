package com.joe.beginzero.strings.reverse;

/**
 * 151. Reverse Words in a String
 *
 * @author ckh
 * @create 2020/8/17 11:46
 */
public class ReverseWords2 {
    public static String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            String str = split[i];
            if (str.length() == 0) {
                continue;
            }
            if (i == 0) {
                stringBuilder.append(str);
            } else {
                stringBuilder.append(str).append(" ");
            }
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {

        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}
