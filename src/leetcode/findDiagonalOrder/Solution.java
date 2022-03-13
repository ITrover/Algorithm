package leetcode.findDiagonalOrder;

import java.util.Arrays;

/**
 * @author itrover
 * 498. 对角线遍历 https://leetcode-cn.com/problems/diagonal-traverse/
 * 模拟
 *
 */
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[][] dirs = new int[][]{{-1,1}, {1,-1}};
        // 右上 j + 1, i - 1
        // 左下 i + 1, j - 1
        int k = 0;
        int i = 0, j = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int a = 0;
        while(k < res.length) {
            int[] dir = dirs[a];
            while (i < m && i >= 0 && j < n && j >= 0) {
                res[k++] = mat[i][j];
                i += dir[0];
                j += dir[1];
            }
            if (a == 0) {
                i++;
                if (j >= n) {
                    i++;
                    j--;
                }
            } else {
                j++;
                if (i >= m) {
                    i--;
                    j++;
                }
            }
            // 调整方向
            a = (a + 1) % 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}
