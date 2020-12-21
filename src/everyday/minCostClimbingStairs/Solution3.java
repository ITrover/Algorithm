package everyday.minCostClimbingStairs;

/**
 * @author itrover
 * 746. 使用最小花费爬楼梯 https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * 动态规划
 */
class Solution3 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i < n; i++) {
            // 第i个位置，要么从上一个位置来，要么从上上个位置来
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        // 结果要么从上一步来，要么从上上一步来
        return Math.min(cost[n - 1], cost[n - 2]);
    }
}
