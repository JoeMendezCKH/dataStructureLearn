package com.joe.beginzero.numberplace;

/**
 * 171. Excel Sheet Column Number
 * <p>
 * 26进制的转换
 *
 * 26 -> 10
 *
 * @author ckh
 * @create 10/13/20 9:20 PM
 */
public class ExcelSheetColumnNumber {

    /**
     * 通过了, 但是太慢了
     */
    public static int titleToNumber1(String s) {

        char[] charArray = s.toCharArray();
        int sum = 0, j = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            int num = charArray[i] - 'A' + 1;
            sum += Math.pow(26, j++) * num;
        }
        return sum;

    }

    public static int titleToNumber2(String s) {

        /*
         * sum  :   总和
         * p    :   每一位的权值
         * num  :   每一位的值
         */
        int sum = 0, p = 1, num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            num = s.charAt(i) - 'A' + 1;
            sum += p * num;
            p *= 26;
        }
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(titleToNumber1("ZAB"));
        System.out.println(titleToNumber2("ZAB"));
    }
}