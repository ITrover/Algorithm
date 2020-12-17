package swordToOffer.maxProfit.improve4;

/**
 * @author itrover
 * 714. 买卖股票的最佳时机含手续费 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 贪心算法
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // 买入费用
        int buy = prices[0] + fee;
        // 收益
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            // 如果买入费用 < 之前buy的费用，则重新购买
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                // 如果当前售价大于了买入费用，则用贪心算法更新收益
                profit += prices[i] - buy;
                // 买入的价格按照prices[i]来算，因为一个收益已经减去了fee
                // 下一次如果 prices[i] > buy 才能够更新
                // 如果下一个次的price + fee 也比 buy小，那么重新买的收益会更大
                buy = prices[i];
            }
        }
        return profit;
    }
}
