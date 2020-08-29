package swordToOffer.maxProfit;

/**
 * 动态规划
 * 用cost记录买入最低的点，
 * 后面买入最高的点-cost就是最大利润
 * 时间复杂度 o(n)
 * 空间复杂度 o(1)
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price:prices) {
            cost = Math.min(cost,price);
            profit = Math.max(profit,price - cost);
        }
        return profit;
    }
}
