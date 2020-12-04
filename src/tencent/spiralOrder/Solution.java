package tencent.spiralOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 54. 螺旋矩阵 https://leetcode-cn.com/problems/spiral-matrix/
 * 模拟打印
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int len = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>(len);
        int l = 0;
        int r = matrix[0].length - 1;
        int u = 0;
        int d = matrix.length - 1;
        while (l <= r && u <= d) {
            // 右
            int k = l;
            while (u <= d && k <= r) {
                res.add(matrix[u][k]);
                k++;
            }
            // 下
            u++;
            k = u;
            while (r >= l && k <= d) {
                res.add(matrix[k][r]);
                k++;
            }
            r--;
            k = r;
            // 左
            while (d >= u && k >= l) {
                res.add(matrix[d][k]);
                k--;
            }
            d--;
            k = d;
            // 上
            while (l <= r && k >= u) {
                res.add(matrix[k][l]);
                k--;
            }
            l++;
        }
        return res;
    }
}
