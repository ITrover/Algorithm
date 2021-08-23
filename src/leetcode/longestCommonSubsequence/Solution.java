package leetcode.longestCommonSubsequence;

import java.util.HashMap;

/**
 * @author itrover
 * 1143. 最长公共子序列 https://leetcode-cn.com/problems/longest-common-subsequence/
 * 找到连续（可以断开）且相等的最长子序列
 * 动态规划
 * 时间复杂度o(mn)
 * 空间复杂度o(mn)
 * 状态转移方程
 *  x[i] = y[j]   c[i + 1][j + 1] = c[i][j] + 1; 保持 i,j之前相等的，并加上当前i + 1,j + 1
 *  x[i] != y[j]  c[i + 1][j + 1] = max(c[i + 1][j],c[i][j + 1]); 寻找i + 1,j或i,j + 1中最长的子序列
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // 第一行和第一列都为0
        // 为了保证第一行和第一列元素的操作和其他元素相同
        // 因为状态转移方程，dp[i][j]的值与dp[i-1][j]和dp[i][j-1]有关
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }
}
