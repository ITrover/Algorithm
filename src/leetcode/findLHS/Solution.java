package leetcode.findLHS;

/**
 * @author itrover
 * 594. 最长和谐子序列 https://leetcode-cn.com/problems/longest-harmonious-subsequence/
 */
class Solution {
    public int findLHS(int[] nums) {
        int res = 0;
        for (int j : nums) {
            int count = 0;
            boolean flag = false;
            // 遍历搜寻num 和 num + 1的数量
            for (int num : nums) {
                if (j == num) {
                    count++;
                } else if (num + 1 == j) {
                    count++;
                    flag = true;
                }
            }
            if (flag) {
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
