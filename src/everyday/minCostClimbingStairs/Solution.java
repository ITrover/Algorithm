package everyday.minCostClimbingStairs;

/**
 * @author itrover
 * 746. 使用最小花费爬楼梯 https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * 动态规划
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        // 初始条件
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            // 到达第i个楼梯的最佳路径为，min(上一个上来，上上一个上来)，不算第i层的花费
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
