package swordToOffer.maxProfit.improve;

/**
 * @author itrover
 * 122. 买卖股票的最佳时机 II https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 动态规划
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp0 表示不持有股票的收益
        // dp1 表示持有股票的收益
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            // 不持有有两种情况，1. 保持昨天不持有。2.卖出昨天持有的
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            // 持有有两种情况，1.保持昨天持有。2.昨天不持有，今天买入
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
