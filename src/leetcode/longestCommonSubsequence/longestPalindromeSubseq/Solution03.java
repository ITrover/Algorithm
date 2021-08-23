package leetcode.longestCommonSubsequence.longestPalindromeSubseq;

/**
 * @author itrover
 * 516. 最长回文子序列 https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 同{@link Solution02}
 */
class Solution03 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[i,j]表示j,i的子字符串中的最大回文子序列长度
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i - 1; j >= 0; j--) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n - 1][0];
    }
}
