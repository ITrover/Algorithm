package leetcode.findCircleNum;

import java.util.LinkedList;

/**
 * @author itrover
 * 547. 省份数量 https://leetcode-cn.com/problems/number-of-provinces/
 * bfs
 */
class Solution2 {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                res++;
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                while (!list.isEmpty()) {
                    Integer node = list.pollFirst();
                    // 广度搜索
                    for (int j = 0; j < isConnected.length; j++) {
                        if (isConnected[node][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            list.offerLast(j);
                        }
                    }
                }
            }
        }
        return res;
    }
}
