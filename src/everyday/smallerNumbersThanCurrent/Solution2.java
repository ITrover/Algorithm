package everyday.smallerNumbersThanCurrent;

import java.util.Arrays;

/**
 * @author itrover
 * 1365. 有多少小于当前数字的数字 https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * 计数统计
 * 时间复杂度o(n+k) 遍历n次
 * 利用题目条件 0 <= num <= 100
 * 统计每个数字出现的次数
 */
class Solution2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return res;
    }
}
