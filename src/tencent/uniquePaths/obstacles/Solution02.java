package tencent.uniquePaths.obstacles;

/**
 * @author itrover
 * 63. 不同路径 II https://leetcode-cn.com/problems/unique-paths-ii/submissions/
 * 动态规划
 */
class Solution02 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length <= 0) {
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][1] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 如果obstacleGrid[i][j]不是障碍物，那么它的值 = 从上来+从左来
                if (obstacleGrid[i][j] != 1) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[n][m];
    }
}
