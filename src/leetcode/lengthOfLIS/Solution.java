package leetcode.lengthOfLIS;

import java.util.Arrays;

/**
 * @author itrover
 * 300. 最长上升子序列 https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 动态规划
 * 时间复杂度o(n^2)
 * 空间复杂度o(n)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 动态规划递推规则
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
