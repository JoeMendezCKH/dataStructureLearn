package com.joe.leetcode.july;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 示例 1:
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * <p>
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * <p>
 * 说明:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joe
 * @create 2020/7/1 9:09
 */
public class MaximumLengthSubarray {
    public static void main(String[] args) {

        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        System.out.println(findLength(A, B));
    }

    /**
     * 滑动窗口, 没理解
     */
    public static int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxLen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxLen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxLen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxLen);
        }
        return ret;
    }

    public static int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }


    /**
     * 动态规划
     * 优化 method2
     * 这是因为dp数组后面的值会依赖前面的值，而前面的值不依赖后面的值，
     * 所以后面的值先修改对前面的没影响，但前面的值修改会对后面的值有影响，所以这里要使用倒序的方式。
     */
    public static int method3(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[] dp = new int[m + 1];
        int result = 0;
        for (int numA : A) {
            for (int j = m; j >= 1; j--) {
                dp[j] = numA == B[j - 1] ? dp[j - 1] + 1 : 0;
                result = Math.max(result, dp[j]);
            }
        }
        return result;
    }

    /**
     * 动态规划
     * 如果有数组A[1,2,3], B[4,1,2]
     * 在暴力解法中, A[2] 与 B[2] 被比较了三次, 三次比较分别是我们计算 A[0:] 与 B[0:] 最长公共前缀、
     * A[1:] 与 B[1:] 最长公共前缀, 以及 A[2:] 与 B[2:] 最长公共前缀时产生的
     * 希望优化这一过程，使得任意一对 A[i] 和 B[j] 都只被比较一次
     * 如果 A[i] == B[j]，那么我们知道 A[i:] 与 B[j:] 的最长公共前缀为 A[i + 1:] 与 B[j + 1:] 的最长公共前缀的长度加一，否则我们知道 A[i:] 与 B[j:] 的最长公共前缀为零
     * <p>
     * 令 dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀，那么答案即为所有 dp[i][j] 中的最大值。如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int method2(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    /**
     * 暴力法
     * 最坏时间复杂度为 O(n^3)
     */
    public static int method1(int[] A, int[] B) {

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int k = 0;
                while (A[i + k] == B[j + k]) {
                    k++;
                }
                result = Math.max(result, k);
            }
        }
        return result;
    }
}
