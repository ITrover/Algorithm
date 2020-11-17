package everyday.allCellsDistOrder;

import java.util.ArrayDeque;

/**
 * @author itrover
 * 1030. 距离顺序排列矩阵单元格 https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 * BFS
 */
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] visited = new boolean[R][C];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int[][] res = new int[R * C][2];
        int c = 0;
        visited[r0][c0] = true;
        deque.add(new int[]{r0, c0});
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                res[c] = deque.pollFirst();
                int x = res[c][0];
                int y = res[c][1];
                c++;
                find(visited, deque, y - 1, y - 1 >= 0, x);
                find(visited, deque, y + 1, y + 1 < C, x);
                find(visited, deque, y, x + 1 < R, x + 1);
                find(visited, deque, y, x - 1 >= 0, x - 1);
            }
        }
        return res;
    }

    private void find(boolean[][] visited, ArrayDeque<int[]> deque, int y, boolean b, int x) {
        if (b && !visited[x][y]) {
            deque.addLast(new int[]{x, y});
            visited[x][y] = true;
        }
    }
}
