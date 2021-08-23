package leetcode.longestCommonSubsequence.longestPalindromeSubseq;

/**
 * @author itrover
 * 516. 最长回文子序列 https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 同最长公共子序列
 * 先反转字符串，然后求最长公共子序列
 */
class Solution02 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[i,j]表示i,j的子字符串中的最大回文子序列长度
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c2 == c1) {
                    // 如果c2 == c1,那么最长回文子序列在[i+1][j-1]的基础上+2
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 如果c2 != c1,那么i,j的最长回文子序列的长度为max([i+1,j],[i,j-1]
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

}
