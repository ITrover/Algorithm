package everyday.findPeakElement;

/**
 * @author itrover
 * 162. 寻找峰值 https://leetcode-cn.com/problems/find-peak-element/
 * 暴力解法
 * 时间复杂度o(n)
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return (nums[1] < nums[0] ? 0 : (nums[n - 2] < nums[n - 1]) ? n - 1 : -1);
    }
}
