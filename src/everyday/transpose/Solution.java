package everyday.transpose;

/**
 * @author itrover
 * 867. 转置矩阵 https://leetcode-cn.com/problems/transpose-matrix/
 * 模拟
 */
class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0][];
        }
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
