package everyday.canPartition;

/**
 * @author itrover
 * 416. 分割等和子集 https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 使用一维矩阵
 * 时间复杂度o(nc)
 * 空间复杂度o(c)
 */
class Solution2 {
    public boolean canPartition(int[] nums) {
        int c = count(nums);
        // 不是偶数，一定不能被拆分
        if ((c & 1) == 1) {
            return false;
        }
        int target = c / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            // 从右到左，需要到的是上一行的信息
            // 如果从左到右，会把上一行的信息覆盖掉
            for (int j = target; j >= 0 && num <= j; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
            if (dp[target]) {
                return true;
            }
        }
        return dp[target];
    }


    int count(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }
}
