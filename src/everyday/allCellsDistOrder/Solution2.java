package everyday.allCellsDistOrder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author itrover
 * 1030. 距离顺序排列矩阵单元格 https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 * 排序
 */
class Solution2 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int k = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[k] = new int[]{i, j};
                k++;
            }
        }
        Arrays.sort(res,Comparator.comparingInt((a)-> Math.abs(a[0] - r0) + Math.abs(a[1] - c0)));
        return res;
    }
}
