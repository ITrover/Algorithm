package leetcode.longestCommonSubsequence.longestPalindromeSubseq;

/**
 * @author itrover
 * 516. 最长回文子序列 https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 同最长公共子序列
 * 先反转字符串，然后求最长公共子序列
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        String s2 = reverse(s);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[n][n];
    }

    String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
