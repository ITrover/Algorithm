package everyday.findMaxAverage;

/**
 * @author itrover
 * 643. 子数组最大平均数 I https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * 滑动窗口
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return -1;
        }
        double max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        double res = max;
        for (int i = k; i < nums.length; i++) {
            max -= nums[i - k];
            max += nums[i];
            res = Math.max(res, max);
        }
        return res / k;
    }
}
