package everyday.longestSubarray;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author itrover
 * 1438. 绝对差不超过限制的最长连续子数组 https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * 滑动窗口 + 单调队列
 */
class Solution2 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> queMax = new LinkedList<Integer>();
        Deque<Integer> queMin = new LinkedList<Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            // 更新最大队列，保证队首的元素最大，大 ---> 小
            while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                queMax.pollLast();
            }
            // 更新最小队列，保证队首的元素最小，小 ---> 大
            while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                queMin.pollLast();
            }
            queMax.offerLast(nums[right]);
            queMin.offerLast(nums[right]);
            // 用最大队列的最大值 - 最小队列的最小值
            while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                if (nums[left] == queMin.peekFirst()) {
                    queMin.pollFirst();
                }
                if (nums[left] == queMax.peekFirst()) {
                    queMax.pollFirst();
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
}
