package leetcode.minPathSum;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/5 20:09
 * @description 64. 最小路径和
 * 典型的动态规划问题
 * 记录每个位置的最短路径的值
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // 初始化
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        // 递推公式
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j - 1] < grid[i - 1][j]) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
