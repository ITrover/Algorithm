package swordToOffer.spiralOrder;

import java.util.Arrays;

class Solution1 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, u = 0, d = matrix.length - 1;
        int[] res = new int[matrix[0].length * matrix.length];
        int index = 0;
        while (l <= r && u <= d) {
            index = printMatrix(res, index, matrix[0].length * matrix.length, matrix, l, r, u, d);
            l++;
            r--;
            u++;
            d--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        int n = 1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[2];
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = n;
                n++;
            }
        }
        Solution1 solution = new Solution1();
        int[] order = solution.spiralOrder(matrix);
        System.out.println(Arrays.toString(order));
    }

    public int printMatrix(int[] res, int index, int length, int[][] matrix, int l, int r, int u, int d) {
        //左到右
        for (int i = l; i < r && index < length; i++) {
            res[index] = matrix[l][i];
            index++;
        }
        //上到下
        for (int i = u; i < d && index < length; i++) {
            res[index] = matrix[i][r];
            index++;
        }
        //右到左
        for (int i = r; i > l && index < length; i--) {
            res[index] = matrix[d][i];
            index++;
        }
        //下到上
        for (int i = d; i > u && index < length; i--) {
            res[index] = matrix[i][l];
            index++;
        }
        if (l == r && u == d && index < length) {
            res[index] = matrix[l][u];
            index++;
        }
        return index;
    }
}
