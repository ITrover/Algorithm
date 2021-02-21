package everyday.longestSubarray;

import java.util.TreeMap;

/**
 * @author itrover
 * 1438. 绝对差不超过限制的最长连续子数组 https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * 滑动窗口 + 有序集合
 */
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            // 记录出现的次数
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            // 使用有序集合中的最大元素- 最小元素
            // 如果不符合条件，则删除左边的元素，直到符合条件
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                // 如果出现的次数为0了，则删除
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
}
