package tencent.uniquePaths;

/**
 * @author itrover
 * 动态规划
 * 时间复杂度O(m*n)
 * 空间复杂度O(m*n)
 */
class Solution2 {

    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        int[][] b = new int[m][n];
        for (int i = 0; i < m; i++) {
            b[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            b[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                b[i][j] = b[i][j - 1] + b[i - 1][j];
            }
        }
        return b[m - 1][n - 1];
    }
}