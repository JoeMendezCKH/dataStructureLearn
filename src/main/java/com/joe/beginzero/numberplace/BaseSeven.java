package com.joe.beginzero.numberplace;

/**
 * 504. base seven
 * 输入范围是 [-1e7, 1e7]
 *
 * @author ckh
 * @create 10/7/20 10:55 AM
 */
public class BaseSeven {
    public static String convertToBase7Method2(int num) {

        StringBuilder sb = new StringBuilder();
        boolean negative = false;

        if (num == 0) {
            sb.append("0");
        }
        if (num < 0) {
            negative = true;
            num = -num;
        }

        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (!negative) {
            return sb.reverse().toString();
        } else {
            return "-" + sb.reverse();
        }
    }

    public static String convertToBase7Method1(int num) {
        return Integer.toString(num, 7);
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7Method1(-123));
    }

}
