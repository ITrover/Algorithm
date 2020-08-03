package swordToOffer.maxValue;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/26 21:09
 */

/**
 * 动态规划
 */
class Solution2 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 初始化第一行
        for(int j = 1; j < n; j++)
        {
            grid[0][j] += grid[0][j - 1];
        }
        // 初始化第一列
        for(int i = 1; i < m; i++)
        {
            grid[i][0] += grid[i - 1][0];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                // 后面每一个都是由前面的向下或向右的来
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
