package leetcode.canFinish;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author itrover
 * 207. 课程表 https://leetcode-cn.com/problems/course-schedule/
 * 拓扑排序
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        // 入度表
        List<Integer>[] adjacency = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency[i] = new ArrayList<>();
        }
        for (int[] prerequisite: prerequisites) {
            indegrees[prerequisite[0]]++;
            adjacency[prerequisite[1]].add(prerequisite[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur: adjacency[pre]) {
                indegrees[cur]--;
                if (indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }
}
