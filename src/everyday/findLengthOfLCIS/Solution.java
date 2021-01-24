package everyday.findLengthOfLCIS;


/**
 * @author itrover
 * 674. 最长连续递增序列 https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * 贪心算法
 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int i = 1;
        int res = 1;
        int t = 1;
        while (i < nums.length) {
            while (i < nums.length && nums[i] > nums[i - 1]) {
                i++;
                t++;
            }
            res = Math.max(res, t);
            t = 1;
            i++;
        }
        return res;
    }
}
