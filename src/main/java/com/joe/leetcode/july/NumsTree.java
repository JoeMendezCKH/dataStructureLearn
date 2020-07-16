package com.joe.leetcode.july;

/**
 * @author ckh
 * @create 2020/7/15 9:07
 */
public class NumsTree {

    /**
     * DP
     * <p>
     * 假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数，则
     * G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)
     * 当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则
     * f(i) = G(i-1)*G(n-i)
     * 综合两个公式可以得到 卡特兰数 公式
     * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     * <p>
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/
     * <p>
     * 这个卡特兰数组是真滴强, 虽然想到了应该是数学公式推出来, 但是没有想到是从 DP 开始推
     */
    public static int numTrees1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    /**
     * 直接使用卡特兰数组计算公式
     */
    public static int numTrees2(int n) {

        // long 类型防止计算过程中的溢出
        long g = 1;
        for (int i = 0; i < n; ++i) {
            g = g * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) g;

    }
}
