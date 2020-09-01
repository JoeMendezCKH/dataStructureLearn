package com.joe.beginzero.strings.transfernumandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 592. Fraction Addition and Subtraction
 *
 * @author ckh
 * @create 9/1/20 9:00 AM
 */
public class FractionAdditionSubtraction {

    public String fractionAddition(String expression) {
        List<int[]> splitExpression = split(expression);
        int lcm = getLCM(splitExpression);

        int upper = 0;
        for (int[] arr : splitExpression) {
            upper += arr[0] * (lcm / arr[1]);
            ;
        }

        int lower = lcm;

        int gcd = getGCD(Math.abs(upper), Math.abs(lower));
        upper /= gcd;
        lower /= gcd;

        StringBuilder res = new StringBuilder();
        res.append(upper).append("/").append(lower);

        return res.toString();
    }

    public List<int[]> split(String expression) {
        List<int[]> list = new ArrayList<>();
        while (expression.length() > 0) {
            int i = expression.indexOf("/");
            // Integer.parseInt(-1) is useful
            int firstNum = Integer.parseInt(expression.substring(0, i));
            // to end
            expression = expression.substring(i + 1);
            int j = 0;
            while (j < expression.length()) {
                if (expression.charAt(j) == '+' || expression.charAt(j) == '-') {
                    break;
                }
                j++;
            }
            int secondNum = Integer.parseInt(expression.substring(0, j));
            expression = expression.substring(j);
            list.add(new int[]{firstNum, secondNum});
        }
        return list;
    }

    public int getLCM(List<int[]> splitExpression) {
        int res = 1;
        for (int[] arr : splitExpression) {
            res = getLCMHelper(res, arr[1]);
        }
        return res;
    }

    public int getLCMHelper(int a, int b) {
        int gcd = getGCD(a, b);
        return a * b / gcd;
    }

    public int getGCD(int a, int b) {
        while (b > 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        FractionAdditionSubtraction subtraction = new FractionAdditionSubtraction();

        String s = subtraction.fractionAddition("-1/2+1/3");

        System.out.println("s = " + s);

        System.out.println(Integer.parseInt("-3"));
        System.out.println(Integer.parseInt("+2"));
    }
}
