package swordToOffer.maxValue;


/**
 * 寻找最大路径
 * DFS
 * 记忆
 * 空间换时间
 */
class Solution {

    public int maxValue(int[][] grid) {
        int[][] arr = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            arr[i] = new int[grid[0].length];
        }
        return bfs(0, 0, grid, arr);
    }


    int bfs(int i, int j, int[][] grid, int[][] arr) {
        // 用来记忆，避免重复结算
        // 记录当前结点到终点的最短距离。

        if (arr[i][j] != 0) {
            return arr[i][j];
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            arr[i][j] = grid[i][j];
            return grid[i][j];
        }
        int down = 0;
        int right = 0;
        if (i < grid.length - 1) {
            down = bfs(i + 1, j, grid, arr);
        }
        if (j < grid[0].length - 1) {
            right = bfs(i, j + 1, grid, arr);
        }
        arr[i][j] = Math.max(down, right) + grid[i][j];
        return arr[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxValue(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }


}
