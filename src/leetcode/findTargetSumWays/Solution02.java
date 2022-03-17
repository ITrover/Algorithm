package leetcode.findTargetSumWays;

import java.util.Arrays;

/**
 * @author itrover
 * 494. 目标和 https://leetcode-cn.com/problems/target-sum/
 * 动态规划，01背包问题
 */
class Solution02 {
    public int findTargetSumWays(int[] nums, int target) {
        // 记总合为sum，前面加负号的数之和为neg，则sum - neg - neg = target
        // 则 neg = (sum - target) / 2
        // 只需要寻找和为neg的数即可，既负数之和为neg，其余为sum - neg， 加起来就是target
        int sum = Arrays.stream(nums).sum();
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = neg; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[neg];
    }
}
