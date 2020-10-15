package com.joe.beginzero.numberplace;

/**
 * 29. Divide Two Integers
 * 没看明白... 嘤嘤嘤
 *
 * @author ckh
 * @create 10/15/2020 7:33 PM
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(divide2(-2147483648, 2));

    }

    /**
     * 解题思路：这题是除法，所以先普及下除法术语
     * <p>
     * 商，公式是：(被除数-余数)÷除数=商，记作：被除数÷除数=商...余数，是一种数学术语。
     * 在一个除法算式里，被除数、余数、除数和商的关系为：(被除数-余数)÷除数=商，记作：被除数÷除数=商...余数，
     * 进而推导得出：商×除数+余数=被除数。
     * <p>
     * 要求商，我们首先想到的是减法，能被减多少次，那么商就为多少，但是明显减法的效率太低
     * <p>
     * 那么我们可以用位移法，因为计算机在做位移时效率特别高，向左移1相当于乘以2，向右位移1相当于除以2
     * <p>
     * 我们可以把一个dividend（被除数）先除以2^n，n最初为31，不断减小n去试探,当某个n满足dividend/2^n>=divisor时，
     * 表示我们找到了一个足够大的数，这个数*divisor是不大于dividend的，所以我们就可以减去2^n个divisor，以此类推
     * 我们可以以100/3为例
     * 2^n是1，2，4，8...2^31这种数，当n为31时，这个数特别大，100/2^n是一个很小的数，肯定是小于3的，所以循环下来，
     * 当n=5时，100/32=3, 刚好是大于等于3的，这时我们将100-32*3=4，也就是减去了32个3，接下来我们再处理4，同样手法可以再减去一个3
     * 所以一共是减去了33个3，所以商就是33
     * 这其中得处理一些特殊的数，比如divisor是不能为0的，Integer.MIN_VALUE和Integer.MAX_VALUE
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        boolean negative;

        //用异或来计算是否符号相异
        negative = (dividend ^ divisor) < 0;

        int t, d;
        if (dividend != Integer.MIN_VALUE) {
            t = Math.abs(dividend);
            d = Math.abs(divisor);
        } else {
            t = dividend;
            d = -Math.abs(divisor);
        }

        int result = 0;

        for (int i = 31; i >= 0; i--) {
            //找出足够大的数2^n*divisor
            if ((t >> i) >= d) {
                // 将结果加上2^n
                result += 1 << i;
                // 将被除数减去2^n*divisor
                t -= d << i;
            }
        }

        //符号相异取反
        return negative ? -result : result;
    }

    /**
     * 正数边界没有负数边界大, 所以用负数进行计算
     * 类似上面的思路,但是是用负数来处理的, 避免使用 long 越界
     */
    public static int divide2(int dividend, int divisor) {
        // 被除数与除数符号是否一致, 不一致为 true
        boolean sign = (dividend ^ divisor) < 0;

        int result = 0;
        // 转化为负数
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }


        while (dividend <= divisor) {
            int tempResult = -1;
            int tempDivisor = divisor;
            while (dividend <= (tempDivisor << 1)) {
                if (tempDivisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                tempResult = tempResult << 1;
                tempDivisor = tempDivisor << 1;
            }
            dividend = dividend - tempDivisor;
            result += tempResult;
        }

        if (!sign) {
            if (result <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = -result;
        }
        return result;
    }
}
