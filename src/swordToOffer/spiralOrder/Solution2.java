package swordToOffer.spiralOrder;

import java.util.Arrays;

/**
 * 每行每列所取个数规则改变
 * 边界问题
 *
 * 本质上和solution1时相同的
 *
 */
class Solution2 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, u = 0, d = matrix.length - 1;
        int[] res = new int[matrix[0].length * matrix.length];
        int index = 0;
        while (l <= r && u <= d) {
            index = printMatrix(res, index, matrix, l, r, u, d);
            l++;
            r--;
            u++;
            d--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[1][];
        int n = 1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[1];
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = n;
                n++;
            }
        }
        Solution2 solution = new Solution2();
        int[] order = solution.spiralOrder(matrix);
        System.out.println(Arrays.toString(order));
    }

    public int printMatrix(int[] res, int index, int[][] matrix, int l, int r, int u, int d) {
        //左到右
        for (int i = l; i <= r; i++) {
            res[index] = matrix[l][i];
            index++;
        }
        u ++;
        //上到下
        for (int i = u; i <= d ; i++) {
            res[index] = matrix[i][r];
            index++;
        }
        r --;
        //右到左
        if (u <= d){
            for (int i = r; i >= l ; i--) {
                res[index] = matrix[d][i];
                index++;
            }
        }
        d --;
        //下到上
        if (l<=r){
            for (int i = d; i >= u ; i--) {
                res[index] = matrix[i][l];
                index++;
            }
        }
        return index;
    }
}
