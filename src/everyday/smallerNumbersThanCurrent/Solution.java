package everyday.smallerNumbersThanCurrent;

/**
 * @author itrover
 * 1365. 有多少小于当前数字的数字 https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * 1.暴力破解
 * 时间复杂度o(n^2) 遍历n次
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        // 每次取一个数、与数组中其他数比较
        for (int num : nums) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > num) {
                    res[j]++;
                }
            }
        }
        return res;
    }
}
