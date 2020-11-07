package leetcode.setZeroes;

import java.util.Arrays;

/**
 * @author itrover
 * 73. 矩阵置零 https://leetcode-cn.com/problems/set-matrix-zeroes/
 * 使用数组第一列和第一行来记录是否置零
 * 时间复杂度o(m*n)
 * 空间复杂度o(1)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row = true;
                    }
                    if (j == 0) {
                        col = true;
                    }
                    // 第i行和第j列需要被置零
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                // 整列置零
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0){
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row){
            Arrays.fill(matrix[0], 0);
        }
        if (col){
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
