package leetcode.treeDiameter;

import java.util.*;

/**
 * @author itrover
 * 1245. 树的直径 https://leetcode-cn.com/problems/tree-diameter/
 * dfs
 */
class Solution {

    int res = 0;

    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] edge:edges) {
            int a = edge[0];
            int b = edge[1];
            List<Integer> aL = g.getOrDefault(a, new ArrayList<Integer>());
            aL.add(b);
            g.put(a, aL);
            List<Integer> bL = g.getOrDefault(b, new ArrayList<Integer>());
            bL.add(a);
            g.put(b, bL);
        }
        dfs(new boolean[edges.length + 1], g, 0);
        return res;
    }

    int dfs(boolean[] visited, Map<Integer, List<Integer>> g, int i) {
        if (visited[i]) {
            return 0;
        }
        List<Integer> edges = g.get(i);
        visited[i] = true;
        int maxDepth01 = 0;
        int maxDepth02 = 0;
        if (edges != null) {
            // 遍历每一个边
            for (int edge:edges) {
                // 对于i结点的最大深度
                int r = dfs(visited, g, edge);
                if (r > maxDepth01) {
                    maxDepth02 = maxDepth01;
                    maxDepth01 = r;
                } else if (r > maxDepth02) {
                    maxDepth02 = r;
                }
            }
        }
        // 更新最大直径(以本结点为中间结点)
        res = Math.max(maxDepth02 + maxDepth01, res);
        // 返回最大深度
        return maxDepth01 + 1;
    }
}
