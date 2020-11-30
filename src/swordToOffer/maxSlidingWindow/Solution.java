package swordToOffer.maxSlidingWindow;

/**
 * @author itrover
 * 剑指 Offer 59 - I. 滑动窗口的最大值 https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * 蛮力法
 * 时间复杂度 o(n*k)
 * 空间复杂度 o(n)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length - k + 1 <= 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = findMax(nums, i, i + k);
        }
        return res;
    }

    int findMax(int[] nums, int start, int end) {
        int res = nums[start];
        for (int i = start; i < end; i++) {
            if (res < nums[i]) {
                res = nums[i];
            }
        }
        return res;
    }
}
