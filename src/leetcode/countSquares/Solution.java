package leetcode.countSquares;

/**
 * @author itrover
 * 1277. 统计全为 1 的正方形子矩阵 https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/
 * 动态规划
 * 时间复杂度o(m*n)
 * 空间复杂度o(m*n)
 */
class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix.length < 1) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    res += dp[i][j];
                }
            }
        }
        return res;
    }
}
