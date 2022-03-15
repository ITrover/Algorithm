package everyday.countMaxOrSubsets;

/**
 * @author itrover
 * 2044. 统计按位或能得到最大值的子集数目 https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/
 * 二进制枚举
 */
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int res = 0, max = 0;
        // 一共有2^n - 1个子集
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            int t = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    t |= nums[j];
                }
            }
            if (t > max) {
                max = t;
                res = 1;
            } else if (t == max) {
                res++;
            }
        }
        return res;
    }
}
