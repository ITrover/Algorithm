package everyday.countRangeSum;

/**
 * @author itrover
 * 327. 区间和的个数 https://leetcode-cn.com/problems/count-of-range-sum/
 * 动态规划
 * i == j dp = nums[i]
 * j > i dp = dp + nums[j]
 * 时间复杂度o(n^2)
 * 通过dp避免累加
 */
class Solution3 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long dp = 0;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            // d为区间[i,j]的和
            for (int j = i; j < nums.length; j++) {
                dp = i == j ? nums[i] : dp + nums[j];
                if (dp >= lower && dp <= upper) {
                    n++;
                }
            }
        }
        return n;
    }
}
