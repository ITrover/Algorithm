package leetcode.firstMissingPositive;

/**
 * @author itrover
 * 41. 缺失的第一个正数 https://leetcode-cn.com/problems/first-missing-positive/
 *
 */
class Solution02 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            // 把小于等于0的数变成n + 1
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                // 将该位置的数置为负数，表示该位置的数存在
                // 能够通过取绝对值将该位置原先的数复原
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            // 该位置大于0，表明该位置对应的数缺失
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
