package leetcode.numSubarraysWithSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * 前缀和 + 哈希表
 */
class Solution02 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            // 记录前缀为sum的子数组个数
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            // 寻找前缀为sum - goal的子数组的个数
            // sum[i] + goal = sum[j]
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }
}
