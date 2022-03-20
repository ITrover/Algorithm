package leetcode.numSubarraysWithSum;

/**
 * @author itrover
 * 930. 和相同的二元子数组 https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 * 滑动窗口
 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int ret = 0;
        while (right < n) {
            sum1 += nums[right];
            // 窗口总合大于goal，将一些元素从左边移除
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            // [left1, left2) 与 right构成的子数组的和都为goal
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ret += left2 - left1;
            right++;
        }
        return ret;
    }
}
