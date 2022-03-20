package everyday.networkBecomesIdle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2039. 网络空闲的时刻 https://leetcode-cn.com/problems/the-time-when-the-network-becomes-idle/
 * bfs
 */
class Solution02 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        List<Integer>[] g = new List[patience.length];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            g[a].add(b);
            g[b].add(a);
        }
        // bfs求最短
        int[] dis = getDis(g);
        int res = 0;
        // 寻找最晚空闲的结点所需要的时间
        for (int i = 1; i < patience.length; i++) {
            int k = patience[i] * ((2 * dis[i] - 1) / patience[i]) + 2 * dis[i];
//            int k = (dis[i] * 4) - ((dis[i] * 2) % patience[i] == 0 ? patience[i] : (dis[i] * 2) % patience[i]);
            res = Math.max(k, res);
        }
        return res + 1;
    }

    int[] getDis(List<Integer>[] g) {
        int[] dis = new int[g.length];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        int k = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int j = 0; j < g[node].size(); j++) {
                    // 避免重复搜索
                    if (dis[g[node].get(j)] == 0) {
                        // 更新距离
                        dis[g[node].get(j)] = k;
                        queue.addLast(g[node].get(j));
                    }
                }
            }
            k++;
        }
        return dis;
    }

    public static void main(String[] args) {
        Solution02 solution = new Solution02();
        solution.networkBecomesIdle(new int[][]{{0, 1}, {0, 2}, {1, 2}}, new int[]{0, 10, 10});
    }
}
