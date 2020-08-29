package swordToOffer.findNumberIn2DArray;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 *      时间复杂度 o(m+n)
 *      空间复杂度 o(1)
 *      利用矩阵的特性，类比二叉查找树
 * @date 2020/8/20 20:14
 */
public class Solution2 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
