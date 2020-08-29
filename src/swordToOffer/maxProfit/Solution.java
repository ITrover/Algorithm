package swordToOffer.maxProfit;

/**
 * 最小子数组的改进
 * 贪心算法
 * 时间复杂度 o(n)
 * 空间复杂度 o(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int pre = 0;
        int maxAns = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            pre = Math.max(pre + tmp, 0);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }
}
