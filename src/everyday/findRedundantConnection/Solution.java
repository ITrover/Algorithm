package everyday.findRedundantConnection;

import java.util.*;

/**
 * @author itrover
 * 684. 冗余连接 https://leetcode-cn.com/problems/redundant-connection/
 * 并查集
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionSet unionSet = new UnionSet(edges.length);
        int[] res = null;
        for (int[] edge : edges) {
            // 统一减1
            boolean b = unionSet.union(edge[0] - 1, edge[1] - 1);
            if (b) {
                res = edge;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {4, 5}, {5, 6}, {1, 6}, {1, 5}});
    }

    class UnionSet {
        private int[] items;
        /**
         * 用于记录每个代表元的坐标
         */
        private List[] map;

        public UnionSet(int size) {
            items = new int[size];
            map = new List[size];
            for (int i = 0; i < size; i++) {
                items[i] = i;
                map[i] = new ArrayList<Integer>();
                map[i].add(i);
            }
        }

        int find(int x) {
            return items[x] == x ? x : find(items[x]);
        }

        boolean union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            // 在同一个连通分支中
            if (fx == fy) {
                return true;
            }
            // x和y不在同一个连通分支中，现在开始合并
            // 以fx作为代表元，更新所有fy
            List<Integer> list = map[fy];
            List<Integer> remain = map[fx];
            for (Integer integer : list) {
                items[integer] = fx;
                // 添加子元素
                remain.add(integer);
            }
            return false;
        }
    }
}
