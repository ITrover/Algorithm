package leetcode.findLength;

/**
 * 718. 最长重复子数组 https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * 动态规划-01背包问题
 */
class Solution02 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    res = Math.max(dp[i + 1][j + 1], res);
                }
            }
        }
        return res;
    }
}
