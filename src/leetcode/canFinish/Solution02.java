package leetcode.canFinish;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 207. 课程表 https://leetcode-cn.com/problems/course-schedule/
 * 深度优先搜索
 */
class Solution02 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 有向图
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i <numCourses; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge: prerequisites) {
            g[edge[1]].add(edge[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(g, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(List<Integer>[] g, int[] visited, int i) {
        // 访问过了
        if (visited[i] == 1) {
            return true;
        }
        // 如果这个结点正在访问，说明成环了
        if (visited[i] == 2) {
            return false;
        }
        // 正在访问
        visited[i] = 2;
        for (int next:g[i]) {
            if (!dfs(g, visited, next)) {
                return false;
            }
        }
        // 访问过了
        visited[i] = 1;
        return true;
    }

}
