package swordToOffer.maxProfit.improve;

/**
 * @author itrover
 * 122. 买卖股票的最佳时机 II https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 贪心算法
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);
        }
        return res;
    }
}
