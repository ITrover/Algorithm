package everyday.canPartition;


/**
 * @author itrover
 * 416. 分割等和子集 https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 0-1背包问题
 * 而且矩阵
 * 时间复杂度o(nc)
 * 空间复杂度o(nc)
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int c = count(nums);
        // 不是偶数，一定不能被拆分
        if (c % 2 != 0){
            return false;
        }
        int target = c / 2;
        int len = nums.length;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }


    int count(int[] nums){
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }
}
