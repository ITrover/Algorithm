package everyday.allCellsDistOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 1030. 距离顺序排列矩阵单元格 https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 * 桶排序
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution4 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bucket.get(dist(i, j, r0, c0)).add(new int[]{i, j});
            }
        }
        int index = 0;
        int[][] res = new int[R * C][];
        for (List<int[]> list : bucket) {
            for (int[] it : list) {
                res[index++] = it;
            }
        }
        return res;
    }
    int dist(int x, int y, int r0, int c0) {
        return Math.abs(x - r0) + Math.abs(y - c0);
    }
}
