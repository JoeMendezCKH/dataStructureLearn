package com.joe.leetcode.july;


/**
 * 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-Xber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joe
 * @create 2020/7/1 10:24
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(lowMethod(31213));
    }

    public static boolean isPalindrome(int num) {
        if (num < 0 || (num >= 10 && num % 10 == 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (num > revertedNumber) {
            revertedNumber = revertedNumber * 10 + num % 10;
            num /= 10;
        }
        // num == revertedNumber / 10; 当 num 是个奇数位长度时，反转一半的revertedNumber包含了中间一位，因此比较的时候需要去掉
        // 如果忘记了, debug 一下就知道了
        return num == revertedNumber || num == revertedNumber / 10;
    }
    public static boolean lowMethod(int num){
        if (num < 0 || (num >= 10 && num % 10 == 0)) {
            return false;
        }
        String s = Integer.toString(num);
        String reverse = new StringBuilder(s).reverse().toString();

        return reverse.equals(s);


    }
}
