package swordToOffer.spiralOrder;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/11 18:47
 */

/**
 * 按顺序模拟打印
 * 退出条件 边界问题
 *  t > b // 上边界大于下边界
 *  l > r // 左边界大于右边界
 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) {
                // left to right.
                res[x++] = matrix[t][i];
            }
            if(++t > b) {
                break;
            }
            for(int i = t; i <= b; i++) {
                // top to bottom.
                res[x++] = matrix[i][r];
            }
            if(l > --r) {
                break;
            }
            for(int i = r; i >= l; i--) {
                // right to left.
                res[x++] = matrix[b][i];
            }
            if(t > --b) {
                break;
            }
            for(int i = b; i >= t; i--) {
                // bottom to top.
                res[x++] = matrix[i][l];
            }
            if(++l > r) {
                break;
            }
        }
        return res;
    }
}

