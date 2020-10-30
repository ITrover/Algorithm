package leetcode.lengthOfLIS;

/**
 * @author itrover
 * 300. 最长上升子序列 https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 动态规划 + 二分查找 贪心算法
 * 时间复杂度o(nlog(n))
 * 空间复杂度o(n)
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) {
            return nums.length;
        }
        int res = 0;
        int i = 0, j = 0;
        // tail记录上升序列
        int[] tail = new int[nums.length];
        for (int num : nums) {
            i = 0;
            j = res;
            // 二分寻找插入位置
            while (i < j) {
                int m = (i + j) / 2;
                if (tail[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tail[i] = num;
            // num插在了tail的最后
            if (j == res) {
                res++;
            }
        }
        return res;
    }
}
