package everyday.pivotIndex;

import java.util.Arrays;

/**
 * @author itrover
 * 724. 寻找数组的中心索引 https://leetcode-cn.com/problems/find-pivot-index/submissions/
 * 前缀和
 */
class Solution2 {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        // 前缀和
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
