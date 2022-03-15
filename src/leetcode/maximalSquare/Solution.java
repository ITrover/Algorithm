package leetcode.maximalSquare;

/**
 * @author itrover
 * 221. 最大正方形 https://leetcode-cn.com/problems/maximal-square/
 * 前缀和 二分查找
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // dp[i][j] 表示以(0,0)为左上角，以(i - 1,j - 1)为右下角的矩形的大小
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + matrix[i][j] - '0';
            }
        }
        int res = -1;
        for (int i = 0; i < m; i++) {
            if (m - i - 1 < res) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (n - j - 1 < res) {
                    break;
                }
                if (matrix[i][j] == '1') {
                    // 以(i,j)为左上角
                    int l = 0, right = Math.min(m - i - 1, n - j - 1);
                    while (l <= right) {
                        int mid = (right - l) / 2 + l;
                        int sum = getSum(preSum, i, j, i + mid, j + mid);
                        if (sum < fullSum(i, i + mid)) {
                            // 范围太大了
                            right = mid - 1;
                        } else if (sum == fullSum(i, i + mid)) {
                            // 全是1
                            res = Math.max(res, mid + 1);
                            // 可以扩大搜索
                            l = mid + 1;
                        }
                    }
                }
            }
        }

        return res > 0 ? res * res : 0;
    }

    int getSum(int[][] preSum, int ai, int aj, int bi, int bj) {
        return preSum[bi + 1][bj + 1] + preSum[ai][aj] - preSum[bi + 1][aj] - preSum[ai][bj + 1];
    }

    int fullSum(int i1, int i2) {
        return (i2 - i1 + 1) * (i2 - i1 + 1);
    }
}
