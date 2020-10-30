package everyday.islandPerimeter;

/**
 * @author itrover
 * 463. 岛屿的周长 https://leetcode-cn.com/problems/island-perimeter/
 * 模拟/暴力破解
 * 时间复杂度o(nm)
 * 空间复杂度o(1)
 * 思考：如果输入不合法，即包含多个不连续岛屿，如何计算出最大岛屿的周长
 *      广度优先搜索，标记访问过的方格
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // 上
                    if (i == 0 || grid[i - 1][j] != 1) {
                        res++;
                    }
                    // 下
                    if (i == grid.length - 1 || grid[i + 1][j] != 1) {
                        res++;
                    }
                    // 左
                    if (j == 0 || grid[i][j - 1] != 1) {
                        res++;
                    }
                    // 右
                    if (j == grid[i].length - 1 || grid[i][j + 1] != 1) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
