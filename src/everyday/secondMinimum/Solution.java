package everyday.secondMinimum;

import java.util.*;

/**
 * @author itrover
 * 2045. 到达目的地的第二短时间 https://leetcode-cn.com/problems/second-minimum-time-to-reach-destination/
 * bfs
 */
class Solution {

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] next = new List[n + 1];
        for (int i = 0; i < next.length; i++) {
            next[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            next[a].add(b);
            next[b].add(a);
        }
        Queue<int[]> queue = new LinkedList<>();
        // 记录访问次数
        int[] visited = new int[n + 1];
        // 记录距离
        int[] dist = new int[n + 1];
        queue.add(new int[]{1, 0});
        // bfs
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int tt = 0;
            int round = node[1] / change;
            // 奇数为绿灯
            if (round % 2 == 0) {
                tt = node[1] + time;
            } else {
                // 红灯时，需要等待红灯结束
                tt = node[1] + time + change - (node[1] % change);
                // 下面写法也对，要等到(round + 1) * change后才能前进（既本轮红灯结束）
                // tt = (round + 1) * change + time;
            }
            for (Integer nxt : next[node[0]]) {
                if (visited[nxt] < 2 && dist[nxt] < tt) {
                    visited[nxt] += 1;
                    dist[nxt] = tt;
                    queue.add(new int[]{nxt, tt});
                }
                if (nxt == n && visited[nxt] == 2) {
                    return dist[nxt];
                }
            }
        }
        return -1;
    }

}
