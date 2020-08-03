package swordToOffer.movingCount;

/**
 * 回溯算法
 * 能上、下、左、右移动就移动
 * 直到不能走了退回来
 */
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                isVisited[i][j] = false;
            }
        }

        return movingCountCore(m, n, k, 0, 0, isVisited);
    }

    // 回溯算法
    public int movingCountCore(int m, int n, int k, int row, int col, boolean[][] isVisited) {
        int count = 0;
        if (check(m, n, k, row, col, isVisited)) {
            isVisited[row][col] = true;
            // 上、下、左、右移动
            count = 1 + movingCountCore(m, n, k, row - 1, col, isVisited)
                    + movingCountCore(m, n, k, row, col - 1, isVisited)
                    + movingCountCore(m, n, k, row + 1, col, isVisited)
                    + movingCountCore(m, n, k, row, col + 1, isVisited);

        }

        return count;
    }

    // 检查是否能够到达
    public boolean check(int m, int n, int k, int row, int col, boolean[][] isVisited) {
        return row >= 0 && row < m && col >= 0 && col < n
                && getNum(row) + getNum(col) <= k
                && !isVisited[row][col];
    }

    public int getNum(int m) {
        int res = 0;
        while (m > 0) {
            res += m % 10;
            m /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(1, 2, 1));
    }
}
