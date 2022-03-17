package leetcode.findTargetSumWays;

import java.util.Arrays;

/**
 * @author itrover
 * 494. 目标和 https://leetcode-cn.com/problems/target-sum/
 * 动态规划，01背包问题
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum() + 1;
        // 不可能达到target
        if (target > sum || target < -sum) {
            return 0;
        }
        int len = sum * 2;
        // 由于有负数，所以整体扩大 sum
        // dp[i][j]表示用前i个数构成j的个数
        int[][] dp = new int[n + 1][len + 1];
        dp[0][sum] = 1;
        for (int i = 0; i < n; i++) {
            // 加上当前数构成j的种类
            for (int j = nums[i]; j < len - nums[i]; j++) {
                dp[i + 1][j] += dp[i][j + nums[i]];
                dp[i + 1][j] += dp[i][j - nums[i]];
            }
            for (int j = len - nums[i]; j < len; j++) {
                dp[i + 1][j] += dp[i][j - nums[i]];
            }
            for (int j = 0; j < nums[i]; j++) {
                dp[i + 1][j] += dp[i][j + nums[i]];
            }
        }
        return dp[n][target + sum];
    }
}
