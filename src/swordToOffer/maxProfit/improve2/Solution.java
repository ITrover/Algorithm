package swordToOffer.maxProfit.improve2;

/**
 * @author itrover
 * 309. 最佳买卖股票时机含冷冻期 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 动态规划
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期（进入冻结期）中的累计最大收益，处于冻结期指的是在第i天结束之后的状态，即i+1不能买入
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            // 递推公式
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        // 最后一天肯定卖出收益高，所以不比较持有的情况
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}
