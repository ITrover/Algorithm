package swordToOffer.maxProfit.improve;

/**
 * @author itrover
 * 122. 买卖股票的最佳时机 II https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 贪心算法
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int j = i;
            // 找到最长的连续子数组
            while (j + 1 < prices.length && prices[j + 1] > prices[j]) {
                j++;
            }
            if (j > i && prices[j] > prices[i]){
                res += prices[j] - prices[i];
                i = j;
            }
        }
        return res;
    }
}
