package leetcode.shortestPathBinaryMatrix;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author itrover
 * 1091. 二进制矩阵中的最短路径 https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 * dfs
 */
class Solution {
    public int shortestPathBinaryMatrix(int[][] grids) {
        if (grids == null || grids.length == 0 || grids[0].length == 0) {
            return -1;
        }
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int x = cur.getKey(), y = cur.getValue();
                // 不是路径，继续查找
                if (grids[x][y] == 1) {
                    continue;
                }
                // 到了终点，返回
                if (x == m - 1 && y == n - 1) {
                    return pathLength;
                }
                // 标记，表示cr,cc这个维护已经访问过了
                grids[x][y] = 1;
                // 构造可能的下一个点
                for (int[] d : direction) {
                    int nr = x + d[0], nc = y + d[1];
                    // 不可能去的点
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }
}
