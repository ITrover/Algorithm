package everyday.coinChange;

import java.util.Arrays;

/**
 * @author itrover
 * 零钱兑换 https://leetcode-cn.com/problems/coin-change/
 * 动态规划，自下而上，从小问题到大问题
 * 通过从0逐步逼近题目条件amount。
 */
class Solution2 {
    public int coinChange(int[] coins, int amount) {
        // 含义：第i个表示，凑到i时，需要的最小硬币数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 100_00);
        // 最小问题
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // 最优子结构，递推公式
                    // coin面值的硬币，是否能够和之前的解，共同组合出当前解，并且找到最少的组合
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == 100_00 ? -1 : dp[amount];
    }
}
