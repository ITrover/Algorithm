package leetcode.maximalSquare;

/**
 * @author itrover
 * 221. 最大正方形 https://leetcode-cn.com/problems/maximal-square/
 * 动态规划
 */
class Solution02 {
    public int maximalSquare(char[][] matrix) {
        // 动态规划
        // 每一个单元格可以和上面和左边构成单元格，取最大值
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // 计算大小
                    int max = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    if (matrix[i - max][j - max] == '1') {
                        dp[i + 1][j + 1] = max + 1;
                    } else {
                        dp[i + 1][j + 1] = max;
                    }
                    res =Math.max(dp[i + 1][j + 1], res);
                }
            }
        }
        return res;
    }

}
