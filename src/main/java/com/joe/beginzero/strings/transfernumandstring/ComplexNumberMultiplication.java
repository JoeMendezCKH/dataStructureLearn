package com.joe.beginzero.strings.transfernumandstring;

/**
 * 537. Complex Number Multiplication
 *
 * @author ckh
 * @create 8/31/20 9:20 AM
 */
public class ComplexNumberMultiplication {

    /**
     * math problem:
     * (a+ib)×(x+iy)=ax + i^2*by + i(bx+ay) = ax − by + i(bx+ay)
     *
     * too slow
     */
    public static String complexNumberMultiply1(String a, String b) {
        String[] x = a.split("\\+|i");
        String[] y = b.split("\\+|i");

        int aReal = Integer.parseInt(x[0]);
        int aImg = Integer.parseInt(x[1]);
        int bReal = Integer.parseInt(y[0]);
        int bImg = Integer.parseInt(y[1]);

        return (aReal * bReal - aImg * bImg) + "+" + (aReal * bImg + bReal * aImg) + "i";
    }

    public static void main(String[] args) {
        String a = "1+1i";
        String b = "2+2i";

        System.out.println(complexNumberMultiply1(a, b));

    }
}
