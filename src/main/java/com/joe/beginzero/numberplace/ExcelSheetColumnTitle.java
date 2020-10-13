package com.joe.beginzero.numberplace;

/**
 * 168. Excel Sheet Column Title
 * <p>
 * 10 -> 26
 *
 * @author ckh
 * @create 10/13/20 9:56 PM
 */
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        int num;
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            num = n % 26;
            n /= 26;
            // 被整除了,需要特殊处理一下,不然 26 的倍数会出错
            if (num == 0) {
                res.append("Z");
                n--;
            } else {
                res.append((char) ('A' + num - 1));
            }
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(26));

    }
}
