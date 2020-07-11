package com.joe.leetcode;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @author Joe
 * @create 2020/7/10 9:00
 */
public class BestTimeToButStock {

    public static void main(String[] args) {

    }

    /**
     * dp
     * 关于这种连续的问题, 都可以考虑用 动态规划 来做
     * 当前的状态取决与之前的状态, 最主要的就是定义好不同的状态, 以及状态转移方程
     * <p>
     * 用 dp[i] 表示第 i 天结束之后的「累计最大收益」,
     * 由于我们最多只能同时买入（持有）一支股票，并且卖出股票后有冷冻期的限制，因此我们会有三种不同的状态
     * - 我们目前持有一支股票，对应的「累计最大收益」记为 dp[i][0]
     * - 我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 dp[i][1]
     * - 我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 dp[i][2]
     * 如果 第 i 天 处于冷冻期, 则第 i+1 天不能购买
     * <p>
     * dp[i][0]:
     *      我们目前持有的这一支股票可以是在第 i-1 天就已经持有的，对应的状态为 dp[i-1][0]
     *      或者是第 i 天买入的，那么第 i-1 天就不能持有股票并且不处于冷冻期中，对应的状态为 dp[i−1][2] 加上买入股票的负收益 prices[i]
     *      dp[i][0] = max{dp[i-1][0], dp[i-1][2]-price[i]}
     * dp[i][1]:
     *      我们在第 i 天结束之后处于冷冻期的原因是在当天卖出了股票，那么说明在第 i-1 天时我们必须持有一支股票, 并且今天卖出了
     *      dp[i][1] = dp[i-1][0] + price[i]
     * dp[i][2]:
     *      我们在第 i 天结束之后不持有任何股票并且不处于冷冻期，说明当天没有进行任何操作，即第 i-1 天时不持有任何股票
     *      dp[i][2] = max{dp[i-1][1], dp[i-1][2]}
     * <p>
     * 这样就得到了所有的状态转移方程
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        // 第 0 天 持有股票, 只能是第0天买入的
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}
