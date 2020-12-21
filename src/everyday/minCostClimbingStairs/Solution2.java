package everyday.minCostClimbingStairs;

/**
 * @author itrover
 * 746. 使用最小花费爬楼梯 https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * 动态规划优化空间
 */
class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 2; i <= n; i++) {
            // 到达第i个楼梯的最佳路径为，min(上一个上来，上上一个上来)，不算第i层的花费
            int t = Math.min(dp1 + cost[i - 1], dp2 + cost[i - 2]);
            // 滚动，dp2和dp1分别上前移动1
            dp2 = dp1;
            dp1 = t;
        }
        return dp1;
    }
}
