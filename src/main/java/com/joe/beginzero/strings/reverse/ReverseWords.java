package com.joe.beginzero.strings.reverse;


/**
 * 557. Reverse Words in a String III
 *
 * @author ckh
 * @create 2020/8/17 11:04
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = s.split(" ");
        for (String str : split) {
            reverseString(str.toCharArray(), stringBuilder);
        }

        return stringBuilder.toString().trim();
    }

    public static void reverseString(char[] s, StringBuilder stringBuilder) {
        int left = 0, right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        stringBuilder.append(s).append(' ');
    }

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));
    }
}
