package tencent.uniquePaths.obstacles;

/**
 * @author itrover
 * 63. 不同路径 II https://leetcode-cn.com/problems/unique-paths-ii/submissions/
 * 回溯，超时
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return recur(obstacleGrid, 0, 0);
    }

    int recur(int[][] obstacleGrid, int i, int j) {
        // 越界
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length) {
            return 0;
        }
        // 障碍物，返回
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        // 到达终点
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        // 往下，往右继续搜索
        return recur(obstacleGrid, i + 1, j) + recur(obstacleGrid, i, j + 1);
    }
}
