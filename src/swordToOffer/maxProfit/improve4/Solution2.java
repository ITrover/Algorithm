package swordToOffer.maxProfit.improve4;

/**
 * @author itrover
 * 714. 买卖股票的最佳时机含手续费 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 动态规划
 */
class Solution2 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // dp[i][0]:第i天不持有收益
        // dp[i][1]:第i天持有收益
        int[][] dp = new int[n][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            // 第i天不持有的收益 = 保持昨天不持有 或 卖出昨天持有
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            // 第i天持有的收益 = 保持昨天持有 或 今天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
