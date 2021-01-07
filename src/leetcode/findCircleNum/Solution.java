package leetcode.findCircleNum;

/**
 * @author itrover
 * 547. 省份数量 https://leetcode-cn.com/problems/number-of-provinces/
 * dfs
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                res++;
                visited[i] = true;
                dfs(isConnected, i, visited);
            }
        }
        return res;
    }

    void dfs(int[][] isConnected, int i, boolean[] visited) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, j, visited);
            }
        }
    }
}
