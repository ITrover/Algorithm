package swordToOffer.maxProfit.improve2;

/**
 * 时间复杂度o(2^n)
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        return bfs(prices, 0, 0);
    }

    /**
     * @param prices
     * @param day
     * @param state  0 不持有、同时没有被冻结、 1 不持有、被冻结、2 持有
     * @return
     */
    int bfs(int[] prices, int day, int state) {
        if (day == prices.length) {
            return 0;
        }
        if (state == 0) {
            // 不持有、同时没有被冻结，可以买、也可以不买
            // 买
            int a = bfs(prices, day + 1, 2) - prices[day];
            // 不买
            int b = bfs(prices, day + 1, 0);
            return Math.max(a, b);
        }

        if (state == 1) {
            // 被冻结了，当前什么也不干、下一状态就是不持有、没有被冻结
            return bfs(prices, day + 1, 0);
        }

        if (state == 2) {
            // 当前持有、要么卖、要么不买
            // 卖，下一状态是冻结
            int a = bfs(prices, day + 1, 1) + prices[day];
            // 不买，下一个状态还是持有
            int b = bfs(prices, day + 1, 2);
            return Math.max(a, b);
        }
        return 0;
    }
}
