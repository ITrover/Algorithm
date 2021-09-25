package everyday.minDistance;

/**
 * @author itrover
 * 583. 两个字符串的删除操作 https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 * 动态规划 把问题转变为求最长公共字串
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return m + n - 2 * dp[n][m];
    }
}
